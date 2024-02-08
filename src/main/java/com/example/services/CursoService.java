package com.example.services;

import java.util.List;

import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Horario;

public interface CursoService {
    public List<Curso> dameCursos();
    public Curso dameUnCurso(int idCurso);
    public void persistirCurso(Curso curso);
    public List<Estudiante> estudiantesPorHorario (Horario horario);

}
