package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Mesa;
import com.forksystem.entities.Reserva;

public interface IReserva extends JpaRepository<Reserva, Long>{

	
	public Reserva findByMesa(Mesa mesa);
}
