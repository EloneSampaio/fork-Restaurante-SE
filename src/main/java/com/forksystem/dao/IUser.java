package com.forksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forksystem.entities.Usuario;

public interface IUser extends JpaRepository<Usuario, Long>{

}
