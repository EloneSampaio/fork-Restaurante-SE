package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.forksystem.entities.TipoPagamento;

public interface ITipoPagamento extends JpaRepository<TipoPagamento, Long>{

	public TipoPagamento findByDescricao(String descricao);
}
