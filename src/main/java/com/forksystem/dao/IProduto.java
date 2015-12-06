package com.forksystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Categoria;
import com.forksystem.entities.Produto;

public interface IProduto extends JpaRepository<Produto, Long>{
	
	List<Produto> findByCategoria(Categoria categoria);

}
