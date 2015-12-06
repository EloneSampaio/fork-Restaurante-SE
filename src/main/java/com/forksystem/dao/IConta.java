package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.forksystem.entities.Conta;

public interface IConta extends JpaRepository<Conta, Long>{

	
}
