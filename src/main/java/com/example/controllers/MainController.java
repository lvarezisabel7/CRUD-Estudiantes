package com.example.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.EstudianteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    
    private final EstudianteService estudianteService;

    private final Logger LOG = Logger.getLogger("MainController");

    @GetMapping("/all")
    public String dameEstudiantes(Model model) {

    model.addAttribute("estudiantes", estudianteService.dameTodosLosEstudiantes());

    return "views/listadoEstudiantes";
}

}
