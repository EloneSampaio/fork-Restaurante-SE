package com.forksystem.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidades")
public class Cidades {

	
	@Id
	@GeneratedValue
	Long id;
	private String nome;
	@ManyToOne(fetch=FetchType.LAZY)
	private Provincias provincia;
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
	public Provincias getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}
	@Override
	public String toString() {
		return  nome;
	}

	
	
	
}
