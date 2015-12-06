package com.forksystem.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor extends Pessoa{

	
    private String site;
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}

	


	
	
}
