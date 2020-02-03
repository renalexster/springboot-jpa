package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@RestController
@RequestMapping("account")
public class AccountController extends AbstractController<Account, AccountRepository> {


	public AccountController(AccountRepository repository) {
		super(repository);
	}

}
