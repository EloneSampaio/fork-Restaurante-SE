package com.forksystem.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente extends Pessoa{
	
	
	/**
	 * desde
	 * variavel que armazena a data em o cliente foi cadastrado
	 */
	@Temporal(TemporalType.DATE)
	private Calendar desde;  
    private String profissao;
    private String empresa;
    private String foneEmpresa;
    private String rendaCLiente;
    private String referencia_cliente;
    private String fone_referencia_cliente;
	public Calendar getDesde() {
		return desde;
	}
	public void setDesde(Calendar desde) {
		this.desde = desde;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getFoneEmpresa() {
		return foneEmpresa;
	}
	public void setFoneEmpresa(String foneEmpresa) {
		this.foneEmpresa = foneEmpresa;
	}
	public String getRendaCLiente() {
		return rendaCLiente;
	}
	public void setRendaCLiente(String rendaCLiente) {
		this.rendaCLiente = rendaCLiente;
	}
	public String getReferencia_cliente() {
		return referencia_cliente;
	}
	public void setReferencia_cliente(String referencia_cliente) {
		this.referencia_cliente = referencia_cliente;
	}
	public String getFone_referencia_cliente() {
		return fone_referencia_cliente;
	}
	public void setFone_referencia_cliente(String fone_referencia_cliente) {
		this.fone_referencia_cliente = fone_referencia_cliente;
	}
	


	
	
	
}
