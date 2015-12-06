package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Cartao;


public interface ICartao extends JpaRepository<Cartao, Long>{

	public Cartao findByNome(String nome);
}
