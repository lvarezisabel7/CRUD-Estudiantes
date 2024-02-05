package com.example.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entities.Correo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CorreoServiceImpl implements CorreoService{

    @Override
    public List<Correo> dameCorreos(int idEstudiante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dameCorreos'");
    }

    @Override
    public void eliminarCorreos(int idEstudiante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCorreos'");
    }

    @Override
    public void persistirCorreo(int idEstudiante, Correo correo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'persistirCorreo'");
    }

}
