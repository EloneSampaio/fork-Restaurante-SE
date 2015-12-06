package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Categoria;

public interface ICategoria extends JpaRepository<Categoria, Long>{
	
	
	public Categoria findByNome(String nome);

}
