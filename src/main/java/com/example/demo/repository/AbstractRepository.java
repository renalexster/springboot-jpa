package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.demo.model.IdEntity;

@NoRepositoryBean
public interface AbstractRepository<T extends IdEntity> extends JpaRepository<T, Long> {

}
