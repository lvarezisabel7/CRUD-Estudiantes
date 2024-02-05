package com.example.services;

import java.util.List;

import com.example.dao.EstudianteDao;
import com.example.dao.TelefonoDao;
import com.example.entities.Telefono;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TelefonoServiceImpl implements TelefonoService {
     
    private final TelefonoDao telefonoDao;
    private final EstudianteDao estudianteDao;

    @Override
    public List<Telefono> telefonos(int idEstudiante) {
        return telefonoDao.findByEstudiante(estudianteDao.findById(idEstudiante).get());
    }

    @Override
    public void eliminarTelefonos(int idEstudiante) {
        telefonoDao.deleteByEstudiante(estudianteDao.findById(idEstudiante).get());
    }

    @Override
    public void persistirTelefono(int idEstudiante, Telefono telefono) {
        telefono.setEstudiante(estudianteDao.findById(idEstudiante).get());
        telefonoDao.save(telefono);
    }

}
