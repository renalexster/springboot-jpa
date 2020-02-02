package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Statement;
import com.example.demo.repository.StatementRepository;

@RestController
@RequestMapping("statement")
public class StatementController extends AbstractController<Statement> {


	public StatementController(StatementRepository repository) {
		super(repository);
	}

}
