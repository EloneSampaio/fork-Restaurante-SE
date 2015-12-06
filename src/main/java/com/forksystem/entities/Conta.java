package com.forksystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contaBancaria")
public class Conta {

	@Id
	@GeneratedValue
	private Long id;
	
	private String agencia;
	private String endereco;
	private String contacto;
	private int numeroConta;
	private String gerente;
	private String banco;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	@Override
	public String toString() {
		return "Conta [id=" + id + ", agencia=" + agencia + ", endereco=" + endereco + ", contacto=" + contacto
				+ ", numeroConta=" + numeroConta + ", gerente=" + gerente + ", banco=" + banco + "]";
	}
	
	
	
	
	
	
}
