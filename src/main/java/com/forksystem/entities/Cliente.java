package com.forksystem.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente extends Pessoa{
	
	
	/**
	 * desde
	 * variavel que armazena a data em o cliente foi cadastrado
	 */
	@Temporal(TemporalType.DATE)
	private Calendar desde;  
    public Calendar getDesde() {
		return desde;
	}
	public void setDesde(Calendar desde) {
		this.desde = desde;
	}
	

	
	
	
}
