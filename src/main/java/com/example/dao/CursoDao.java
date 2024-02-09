package com.example.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Curso;
import com.example.entities.Horario;

import java.util.List;


@Repository
public interface CursoDao extends JpaRepository<Curso, Integer>{

    public List<Curso> findByHorario(Horario horario);
   

}
