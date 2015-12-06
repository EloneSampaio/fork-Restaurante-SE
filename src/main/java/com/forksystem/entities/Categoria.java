package com.forksystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String descricao;
	private String img;
	@OneToMany(mappedBy="categoria",orphanRemoval=true)
	private List<Produto> produtos=new ArrayList<Produto>();
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	public Categoria() {
		super();
	}

	@Override
	public String toString() {
		return  nome ;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
	
	
	
	
}
