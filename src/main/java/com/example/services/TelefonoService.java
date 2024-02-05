package com.example.services;

import java.util.List;

import com.example.entities.Telefono;

public interface TelefonoService {
    public List<Telefono> telefonos(int idEstudiante);
    public void eliminarTelefonos(int idEstudiante); 
    public void persistirTelefono(int idEstudiante, Telefono telefono);


}
