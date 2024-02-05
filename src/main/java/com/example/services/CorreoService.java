package com.example.services;

import java.util.List;

import com.example.entities.Correo;

public interface CorreoService {
    public List<Correo> dameCorreos(int idEstudiante);
    public void eliminarCorreos(int idEstudiante);
    public void persistirCorreo(int idEstudiante, Correo correo);

}
