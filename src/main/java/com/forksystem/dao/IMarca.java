package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Categoria;
import com.forksystem.entities.Marca;

public interface IMarca extends JpaRepository<Marca, Long>{

	
	public Marca findByNome(String nome);
}
