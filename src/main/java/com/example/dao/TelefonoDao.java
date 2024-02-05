package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Estudiante;
import com.example.entities.Telefono;

public interface TelefonoDao extends JpaRepository<Telefono, Integer> {
    List<Telefono> findByEstudiante(Estudiante estudiante);
    void deleteByEstudiante(Estudiante estudiante);

}
