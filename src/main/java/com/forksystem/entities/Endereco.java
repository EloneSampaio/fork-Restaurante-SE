package com.forksystem.entities;

public class Endereco {

	private String estado;
	private String cidade;
	private String municipio;
	private String bairro;
	private String cep;
	private Integer numero;
	private String endereco;
	private String uf;
	
	
	
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Endereco [estado=" + estado + ", cidade=" + cidade + ", municipio=" + municipio + ", bairro=" + bairro
				+ ", cep=" + cep + ", numero=" + numero + ", endereco=" + endereco + ", uf=" + uf + "]";
	}
	
	
	
	
}
