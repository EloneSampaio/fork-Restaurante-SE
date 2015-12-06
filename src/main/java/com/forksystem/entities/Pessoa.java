package com.forksystem.entities;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="pessoa")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="nome",nullable=false,length=30)
	private String nome;
	@Column(name="data",nullable=true)
	private Calendar data;
	private String genero;
	
	@Embedded
	@Column(name="endereco",nullable=false,length=50)
	private Endereco endereco;
	
    @Embedded
    @Column(name="contacto",nullable=true,length=50)
    private Contacto contacto;
	@Column(name="cpf",nullable=false,unique=true)
	private String cpf;
	
	
	
	
    
	public Pessoa() {
		
	}


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


	

	

	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}





	public String toString(){
		return this.nome+"("+id+")";
		
	}
	public String getSexo() {
		return genero;
	}


	public void setSexo(String sexo) {
		this.genero = sexo;
	}


	public Calendar getData() {
		return data;
	}


	public void setData(Calendar data) {
		this.data = data;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Contacto getContacto() {
		return contacto;
	}


	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	
	
		
	
}
