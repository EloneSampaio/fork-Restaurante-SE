package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forksystem.entities.Categoria;
import com.forksystem.entities.Unidade;

@Repository
public interface IUnidade extends JpaRepository<Unidade,Long>{

	public Unidade findByNome(String nome);
}
