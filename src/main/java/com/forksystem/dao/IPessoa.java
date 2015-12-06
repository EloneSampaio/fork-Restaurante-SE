package com.forksystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.forksystem.entities.Cliente;
import com.forksystem.entities.Fornecedor;
import com.forksystem.entities.Funcionario;
import com.forksystem.entities.Pessoa;

@Repository
public interface IPessoa extends JpaRepository<Pessoa, Long>{
	
	
	
	
public List<Pessoa> findByNomeLike(String nome);
		
@Query("select u from Cliente u where u.id = ?1")
public Cliente findByCliente(Long id);

@Query("select u from Fornecedor u where u.id =?1")
public Fornecedor findByFornecedor(Long id);

@Query("select u from Funcionario u where u.id =?1")
public Funcionario findByFuncionario(Long id);
	
@Query("select u from Cliente u order by u.id desc")
public List<Cliente> findAllClientes();

@Query("select u from Funcionario u order by u.id desc")
public List<Funcionario> findAllFuncionarios();	

@Query("select u from Fornecedor u order by u.id desc")
public List<Fornecedor> findAllFornecedors();	



}