package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Cartao;
import com.forksystem.entities.Departamento;


public interface IDepartamento extends JpaRepository<Departamento, Long>{

	
}
