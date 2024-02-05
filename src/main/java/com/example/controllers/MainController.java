package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/all")
    public String dameEstuandiantes(Model model) {

    model.addAttribute("estudiantes", estudianteService.dameTodosLosEstudiantes());

    return "views/listadoEstudiantes";
}

}