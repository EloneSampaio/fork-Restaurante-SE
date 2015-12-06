package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forksystem.entities.Mesa;

@Repository
public interface IMesa extends JpaRepository<Mesa, Long>{

	public Mesa findByNome(String nome); 
	
}
