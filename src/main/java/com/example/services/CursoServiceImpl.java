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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dameCursos'");
    }

    @Override
    public Curso dameUnCurso(int idDCurso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dameUnCurso'");
    }

    @Override
    public void persistirCurso(Curso curso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'persistirCurso'");
    }

}
