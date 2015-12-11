package com.forksystem.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="operacao")
public class Operacao {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="produto_id",nullable=false,unique=true)
	private Produto produto;
	@Column(name="quantidade",nullable=false)
	private BigDecimal qtd;
	@Column(name="tipo_operacao",nullable=false)
	private Integer tipo;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public BigDecimal getQtd() {
		return qtd;
	}
	
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public void setQtd(BigDecimal qtd) {
		this.qtd = qtd;
	}
	@Override
	public String toString() {
		return "Operacao [id=" + id + ", produto=" + produto + ", qtd=" + qtd + ", tipo=" + tipo + ", data=" + data
				+ "]";
	}


	
	
}
