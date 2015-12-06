package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.forksystem.entities.Operacao;
import com.forksystem.entities.Produto;

@Repository
public interface IOperacao extends JpaRepository<Operacao, Long>{

	Operacao findByProduto(Produto id);
	
	@Query("SELECT sum(qtd) FROM Operacao where produto=:produto AND tipo=:tipo  ")
	Integer buscaByTipo(@Param("produto") Produto produto, @Param("tipo")Integer tipo);
		
}