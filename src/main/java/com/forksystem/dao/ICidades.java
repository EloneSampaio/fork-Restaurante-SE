package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forksystem.entities.Cidades;

@Repository
public  interface ICidades extends JpaRepository<Cidades, Long>{

	
	
}
