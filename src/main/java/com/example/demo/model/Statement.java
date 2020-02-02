package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Statement implements IdEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Double ammount;
	@Enumerated(EnumType.STRING)
	private TypeStatement type;
	@Column
	private LocalDateTime dateTime;
	@ManyToOne
	private Account account;
	
	public enum TypeStatement {
		DEPOSIT, WITHDRAW
	};
}
