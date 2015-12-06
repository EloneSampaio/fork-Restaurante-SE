package com.forksystem.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Classe que guarda dados das contas a pagar e a receber
 */
@Entity
@Table(name="conta_pagar")
public class ContaPagamento {
	
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String descricao;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column(name="valor_pagar",nullable=false)
	private BigDecimal valor;
	@Column(name="data_vencimento",nullable=false)
	private Calendar dataVencimento;
	@Column(name="data_entrada",nullable=false)
	private Calendar dataEntrada;
	/*
	 *campo do tipo char que armazena o tipo de conta a ser persistido 
	 */
	@Column(name="tipo_conta",nullable=false,length=2)
	private int tipo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Calendar getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Calendar getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	

}
