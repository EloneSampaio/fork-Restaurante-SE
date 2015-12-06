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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pagamento")
public class Pagamento {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "numero_pagamento")
	private String numeroPagamento;
	@Column(name = "valor_total_pagamento")
	private BigDecimal vlorTotalPagamento;
	@Column(name = "valor_juro_pagamento")
	private BigDecimal vlorJuroPagamento;
	@Column(name = "valor_multa_pagamento")
	private BigDecimal vlorMultaPagamento;
	@Column(name = "valor_desconto_pagamento")
	private Integer vlorDoDesconto;
	@Column(name = "valor_pagamento")
	private BigDecimal vlorPago;
	@Column(name = "numero_cheque_pagamento")
	private Integer numeroChequePagamento;
	@Column(name = "nominal_pagamento")
	private Integer nominalPagamento;
	@Temporal(TemporalType.DATE)
	private Calendar emissao;
	@Temporal(TemporalType.DATE)
	private Calendar lancamento;
	@Temporal(TemporalType.DATE)
	private Calendar vencimento;
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;
	@Temporal(TemporalType.DATE)
	private Calendar dataChequePagamento;
	
	@Enumerated(EnumType.STRING)
	private TipoPagamentos tipoPagamento;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataChequePagamento == null) ? 0 : dataChequePagamento.hashCode());
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + ((emissao == null) ? 0 : emissao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lancamento == null) ? 0 : lancamento.hashCode());
		result = prime * result + ((nominalPagamento == null) ? 0 : nominalPagamento.hashCode());
		result = prime * result + ((numeroChequePagamento == null) ? 0 : numeroChequePagamento.hashCode());
		result = prime * result + ((numeroPagamento == null) ? 0 : numeroPagamento.hashCode());
		result = prime * result + ((getTipoPagamento() == null) ? 0 : getTipoPagamento().hashCode());
		result = prime * result + ((vencimento == null) ? 0 : vencimento.hashCode());
		result = prime * result + ((vlorDoDesconto == null) ? 0 : vlorDoDesconto.hashCode());
		result = prime * result + ((vlorJuroPagamento == null) ? 0 : vlorJuroPagamento.hashCode());
		result = prime * result + ((vlorMultaPagamento == null) ? 0 : vlorMultaPagamento.hashCode());
		result = prime * result + ((vlorPago == null) ? 0 : vlorPago.hashCode());
		result = prime * result + ((vlorTotalPagamento == null) ? 0 : vlorTotalPagamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (dataChequePagamento == null) {
			if (other.dataChequePagamento != null)
				return false;
		} else if (!dataChequePagamento.equals(other.dataChequePagamento))
			return false;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (emissao == null) {
			if (other.emissao != null)
				return false;
		} else if (!emissao.equals(other.emissao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lancamento == null) {
			if (other.lancamento != null)
				return false;
		} else if (!lancamento.equals(other.lancamento))
			return false;
		if (nominalPagamento == null) {
			if (other.nominalPagamento != null)
				return false;
		} else if (!nominalPagamento.equals(other.nominalPagamento))
			return false;
		if (numeroChequePagamento == null) {
			if (other.numeroChequePagamento != null)
				return false;
		} else if (!numeroChequePagamento.equals(other.numeroChequePagamento))
			return false;
		if (numeroPagamento == null) {
			if (other.numeroPagamento != null)
				return false;
		} else if (!numeroPagamento.equals(other.numeroPagamento))
			return false;
		if (getTipoPagamento() == null) {
			if (other.getTipoPagamento() != null)
				return false;
		} else if (!getTipoPagamento().equals(other.getTipoPagamento()))
			return false;
		if (vencimento == null) {
			if (other.vencimento != null)
				return false;
		} else if (!vencimento.equals(other.vencimento))
			return false;
		if (vlorDoDesconto == null) {
			if (other.vlorDoDesconto != null)
				return false;
		} else if (!vlorDoDesconto.equals(other.vlorDoDesconto))
			return false;
		if (vlorJuroPagamento == null) {
			if (other.vlorJuroPagamento != null)
				return false;
		} else if (!vlorJuroPagamento.equals(other.vlorJuroPagamento))
			return false;
		if (vlorMultaPagamento == null) {
			if (other.vlorMultaPagamento != null)
				return false;
		} else if (!vlorMultaPagamento.equals(other.vlorMultaPagamento))
			return false;
		if (vlorPago == null) {
			if (other.vlorPago != null)
				return false;
		} else if (!vlorPago.equals(other.vlorPago))
			return false;
		if (vlorTotalPagamento == null) {
			if (other.vlorTotalPagamento != null)
				return false;
		} else if (!vlorTotalPagamento.equals(other.vlorTotalPagamento))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroPagamento() {
		return numeroPagamento;
	}

	public void setNumeroPagamento(String numeroPagamento) {
		this.numeroPagamento = numeroPagamento;
	}

	public BigDecimal getVlorTotalPagamento() {
		return vlorTotalPagamento;
	}

	public void setVlorTotalPagamento(BigDecimal vlorTotalPagamento) {
		this.vlorTotalPagamento = vlorTotalPagamento;
	}

	public BigDecimal getVlorJuroPagamento() {
		return vlorJuroPagamento;
	}

	public void setVlorJuroPagamento(BigDecimal vlorJuroPagamento) {
		this.vlorJuroPagamento = vlorJuroPagamento;
	}

	public BigDecimal getVlorMultaPagamento() {
		return vlorMultaPagamento;
	}

	public void setVlorMultaPagamento(BigDecimal vlorMultaPagamento) {
		this.vlorMultaPagamento = vlorMultaPagamento;
	}

	public Integer getVlorDoDesconto() {
		return vlorDoDesconto;
	}

	public void setVlorDoDesconto(Integer vlorDoDesconto) {
		this.vlorDoDesconto = vlorDoDesconto;
	}

	public BigDecimal getVlorPago() {
		return vlorPago;
	}

	public void setVlorPago(BigDecimal vlorPago) {
		this.vlorPago = vlorPago;
	}

	public Integer getNumeroChequePagamento() {
		return numeroChequePagamento;
	}

	public void setNumeroChequePagamento(Integer numeroChequePagamento) {
		this.numeroChequePagamento = numeroChequePagamento;
	}

	public Integer getNominalPagamento() {
		return nominalPagamento;
	}

	public void setNominalPagamento(Integer nominalPagamento) {
		this.nominalPagamento = nominalPagamento;
	}

	public Calendar getEmissao() {
		return emissao;
	}

	public void setEmissao(Calendar emissao) {
		this.emissao = emissao;
	}

	public Calendar getLancamento() {
		return lancamento;
	}

	public void setLancamento(Calendar lancamento) {
		this.lancamento = lancamento;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Calendar getDataChequePagamento() {
		return dataChequePagamento;
	}

	public void setDataChequePagamento(Calendar dataChequePagamento) {
		this.dataChequePagamento = dataChequePagamento;
	}

	public TipoPagamentos getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamentos tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	
	
	
	
}
