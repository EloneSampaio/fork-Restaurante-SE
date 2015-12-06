package com.forksystem.dao;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Mesa;
import com.forksystem.entities.Pedido;


public interface IPedido extends JpaRepository<Pedido, Long>{

	public Pedido findBydataCriacao(Calendar data);
	public Pedido findByMesa(Mesa mesa);
}
