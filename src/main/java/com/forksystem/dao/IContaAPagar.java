package com.forksystem.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.forksystem.entities.ContaPagamento;
import com.forksystem.entities.Status;

@Repository
public interface IContaAPagar extends JpaRepository<ContaPagamento, Long> {

	@Query("SELECT sum(valor) FROM ContaPagamento where dataVencimento<:data AND status!=:valor ")
	public Integer buscarContaVencida(@Param("data") Calendar data,@Param("valor") Status status);

	@Query("SELECT sum(valor) FROM ContaPagamento where status=:status ")
	public Integer buscarContaPagas(@Param("status") Status status);
	
	@Query("SELECT sum(valor) FROM ContaPagamento where status=:status AND dataVencimento>:data ")
	public Integer buscarConta(@Param("status") Status status,@Param("data") Calendar data);
	
	public List<ContaPagamento> findByTipo(int tipo);
}
