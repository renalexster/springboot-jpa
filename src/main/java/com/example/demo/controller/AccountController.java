package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping("account")
public class AccountController extends AbstractController<Person> {


	public AccountController(PersonRepository repository) {
		super(repository);
	}

}
