package com.forksystem.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cartao")
public class Cartao {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private BigDecimal taxaCobranca;
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
	public BigDecimal getTaxaCobranca() {
		return taxaCobranca;
	}
	public void setTaxaCobranca(BigDecimal taxaCobranca) {
		this.taxaCobranca = taxaCobranca;
	}
	@Override
	public String toString() {
		return nome;
	}
	
	
	
}
