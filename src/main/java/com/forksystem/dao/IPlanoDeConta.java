package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Cartao;
import com.forksystem.entities.Departamento;
import com.forksystem.entities.PlanoConta;


public interface IPlanoDeConta extends JpaRepository<PlanoConta, Long>{

	
}
