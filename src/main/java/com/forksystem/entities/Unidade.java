package com.forksystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unidade")
public class Unidade {

	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Unidade(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	public Unidade() {
		
	}

	@Override
	public String toString() {
		return nome;
	}
}
