package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Pagamento;


public interface IPagamento extends JpaRepository<Pagamento, Long>{

	
}
