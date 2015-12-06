package com.forksystem.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="recebimento")
public class Recebimento {

   @Id
   @GeneratedValue
	private Long Id;
   @Column(name = "numero_recebimento")
	private String numeroRecebimento;
	@Column(name = "valor_total_recebimento")
	private BigDecimal vlorTotalRecebimento;
	@Column(name = "valor_juro_recebimento")
	private BigDecimal vlorJuroRecebimento;
	@Column(name = "valor_multa_recebimento")
	private BigDecimal vlorMultaRecebimento;
	@Column(name = "valor_desconto_recebimento")
	private BigDecimal vlorDoDesconto;
	@Column(name = "valor_recebido")
	private BigDecimal vlorRecebido;
	@Temporal(TemporalType.DATE)
	private Calendar emissao;
	@Temporal(TemporalType.DATE)
	private Calendar lancamento;
	@Temporal(TemporalType.DATE)
	private Calendar vencimento;
	@Temporal(TemporalType.DATE)
	private Calendar dataRecebimento;
	@OneToOne
	private PlanoConta planoConta;
	@ManyToOne
	private TipoPagamento tipoPagamento;
	@OneToOne
	private Conta conta;
	@OneToOne
	private Cliente cliente;

	
	
   
}
