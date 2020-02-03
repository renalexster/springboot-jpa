package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.IdEntity;
import com.example.demo.repository.AbstractRepository;

public abstract class AbstractController<T extends IdEntity, K extends AbstractRepository<T>> {

	protected K repository;
	
	public AbstractController(K repository) {
		this.repository = repository;
	}
	
	@GetMapping()
	public List<T> findAll() {
		return repository.findAll();
	}
	
	@PostMapping()
	public T persist(@RequestBody T entity) {
		return repository.save(entity);
	}

	@PutMapping(value = "/{id}")
	public T update(@PathVariable Long id, @RequestBody T entity) {
		T persistedEntity = repository.getOne(id);

		if (persistedEntity != null) {
			BeanUtils.copyProperties(entity, persistedEntity);

			return repository.save(persistedEntity);
		}

		return null;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		boolean exists = repository.existsById(id);

		if (exists) {
			repository.deleteById(id);
		}
	}


}
