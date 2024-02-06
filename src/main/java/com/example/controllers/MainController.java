package com.example.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Estudiante;
import com.example.services.CursoService;
import com.example.services.EstudianteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    
    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    private final Logger LOG = Logger.getLogger("MainController");

    @GetMapping("/all")
    public String dameEstudiantes(Model model) {

    model.addAttribute("estudiantes", estudianteService.dameTodosLosEstudiantes());

    return "views/listadoEstudiantes";
    }

    @GetMapping("/detalles/{id}")
    public String detallesEstudiante(@PathVariable(name = "id") int idEstudiante, Model model) {

        LOG.info("El id del estudiante es: " + idEstudiante);

        model.addAttribute("estudiante", estudianteService.dameUnEstudiante(idEstudiante)); 
        
        

        return "views/detallesEstudiante";
    }

    @GetMapping("/frmAltaModificacionEstudiante")
    public String formularioAltaModificacion(Model model) {

        // Le paso al modelo un objeto estudiante vacio
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);

        // Necesitamos enviar tambien los cursos
        model.addAttribute("cursos", cursoService.dameCursos());

        return "views/frmAltaModificacionEstudiante";
    }


}
