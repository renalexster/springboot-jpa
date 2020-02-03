package com.example.demo.controller;

import static com.example.demo.model.Statement.TypeStatement.DEPOSIT;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Account;
import com.example.demo.model.Statement;
import com.example.demo.model.Statement.TypeStatement;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.StatementRepository;

@RestController
@RequestMapping("statement")
public class StatementController extends AbstractController<Statement, StatementRepository> {

	private AccountRepository accountRepository;
	
	public StatementController(StatementRepository repository, AccountRepository accountRepository) {
		super(repository);
		this.accountRepository = accountRepository;
	}
	
	@PatchMapping(value = "deposit/account/{id}")
	public Statement depositToAccount(@PathVariable Long id, @RequestParam(name = "value") double value) {
		Statement entity = Statement.builder()
				.ammount(value)
				.dateTime(LocalDateTime.now())
				.type(DEPOSIT)
				.account(accountRepository.findById(id).get()).build();
		return repository.save(entity);
	}
	
	@PatchMapping(value = "withdraw/account/{id}")
	public Statement withdrawFromAccount(@PathVariable Long id, @RequestParam(name = "value") double value) {
		Account account = accountRepository.findById(id).get();
		List<Statement> accountStatements = repository.findByAccountId(id);
		
		double accountBalance = accountStatements.stream()
			.mapToDouble(st -> st.getType().equals(DEPOSIT) ? st.getAmmount() : -1 * st.getAmmount())
			.reduce(0d, (st1, st2) ->  st1 + st2);
		
		if (value > accountBalance) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insuficient balance");
		
		Statement entity = Statement.builder()
				.ammount(value)
				.dateTime(LocalDateTime.now())
				.type(TypeStatement.WITHDRAW)
				.account(account).build();
		return repository.save(entity);
	}


}
