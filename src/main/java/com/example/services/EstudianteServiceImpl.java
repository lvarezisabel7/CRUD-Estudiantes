package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.dao.EstudianteDao;
import com.example.entities.Estudiante;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteDao estudianteDao;


    @Override
    public List<Estudiante> dameTodosLosEstudiantes() {
        return estudianteDao.findAll();
    }

    @Override
    public Estudiante dameUnEstudiante(int idEstudiante) {
        return estudianteDao.findById(idEstudiante).get();
    }

    @Override
    public void persistirEstudiante(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(int idEstudiante) {
        estudianteDao.deleteById(idEstudiante);
    }

}
