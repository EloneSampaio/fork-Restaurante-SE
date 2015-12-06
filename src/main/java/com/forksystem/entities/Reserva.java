package com.forksystem.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false,unique=true)
	private String documento;
	@Column(nullable=false)
	private Integer telefone;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Calendar hora;
	@Column(nullable=false,name="numeo_de_pessoas")
	private Integer numeroPessoas;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Mesa mesa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public Calendar getHora() {
		return hora;
	}
	public void setHora(Calendar hora) {
		this.hora = hora;
	}
	public Integer getNumeroPessoas() {
		return numeroPessoas;
	}
	public void setNumeroPessoas(Integer numeroPessoas) {
		this.numeroPessoas = numeroPessoas;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", nome=" + nome + ", documento=" + documento + ", telefone=" + telefone
				+ ", hora=" + hora + ", numeroPessoas=" + numeroPessoas + ", mesa=" + mesa + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mesa == null) ? 0 : mesa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroPessoas == null) ? 0 : numeroPessoas.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mesa == null) {
			if (other.mesa != null)
				return false;
		} else if (!mesa.equals(other.mesa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroPessoas == null) {
			if (other.numeroPessoas != null)
				return false;
		} else if (!numeroPessoas.equals(other.numeroPessoas))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	
	

}
