package com.forksystem.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

	@OneToOne
	private Departamento departamento;
	private String funcao;
	@Temporal(TemporalType.DATE)
	private Calendar admissao;
	private String imagem;
	
	

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Calendar getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Calendar admissao) {
		this.admissao = admissao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
