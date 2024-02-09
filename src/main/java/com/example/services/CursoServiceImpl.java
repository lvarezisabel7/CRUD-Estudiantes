package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.dao.CursoDao;
import com.example.dao.EstudianteDao;
import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Horario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService{

    private final CursoDao cursoDao;

    @Override
    public List<Curso> dameCursos() {
        return cursoDao.findAll();
    }

    @Override
    public Curso dameUnCurso(int idCurso) {
        return cursoDao.findById(idCurso).get();
    }

    @Override
    public void persistirCurso(Curso curso) {
        cursoDao.save(curso);
    }

    @Override
    public List<Estudiante> estudiantesPorHorario(Horario horario) {
        return cursoDao.findByHorario(horario).stream()
                .filter(curso -> curso.getHorario().equals(Horario.DIURNO))
                .flatMap(curso -> curso.getEstudiantes().stream()) 
                .collect(Collectors.toList());
    }

    @Override
    public List<Estudiante> estudiantesPorCurso(Curso curso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estudiantesPorCurso'");
    }

}
