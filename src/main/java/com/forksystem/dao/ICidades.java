package com.forksystem.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forksystem.entities.Cidades;
import com.forksystem.entities.Provincias;

@Repository
public  interface ICidades extends JpaRepository<Cidades, Long>{

	public Collection<? extends Cidades> findByProvincia(Provincias provincia);
	
}
