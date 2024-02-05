package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.CursoDao;
import com.example.entities.Curso;

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
    public Curso dameUnCurso(int idDCurso) {
        return cursoDao.findById(idDCurso).get();
    }

    @Override
    public void persistirCurso(Curso curso) {
        cursoDao.save(curso);
    }

}
