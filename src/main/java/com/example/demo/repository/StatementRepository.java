package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Statement;

public interface StatementRepository extends AbstractRepository<Statement> {
	List<Statement> findByAccountId(Long account);
}
