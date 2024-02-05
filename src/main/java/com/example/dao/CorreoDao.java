package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Correo;


public interface CorreoDao extends JpaRepository<Correo, Integer> {
    List<Correo> findByNombre(String nombre); 

}
