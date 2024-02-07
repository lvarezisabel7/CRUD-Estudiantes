package com.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Correo;
import com.example.entities.Estudiante;
import com.example.entities.Telefono;
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

    @PostMapping("/persistir")
    @Transactional
    public String persistirEstudiante(@ModelAttribute(name = "estudiante") Estudiante estudiante,
            @RequestParam(name = "numerosTel", required = false) String telefonosRecibidos,
            @RequestParam(name = "direccionesCorreo", required = false) String correosRecibidos) {
        
        // Procesar los telefonos
        if(telefonosRecibidos != null) {
            String[] arrayTelefonos = telefonosRecibidos.split(";");
            List<String> numerosTelefonos = Arrays.asList(arrayTelefonos);

            List<Telefono> telefonos = new ArrayList<>();

            numerosTelefonos.stream()
                .forEach(numeroTelefono -> {
                    telefonos.add(Telefono.builder()
                        .telefono(numeroTelefono)
                        .estudiante(estudiante)
                        .build());
                });

            estudiante.setTelefonos(telefonos);

            }

            // Procesar los correos
            if(correosRecibidos != null) {
                String[] arrayCorreos = correosRecibidos.split(";");
                List<String> direccionesDeCorreo = Arrays.asList(arrayCorreos);

                List<Correo> correos = new ArrayList<>();

                direccionesDeCorreo.stream()
                    .forEach(direccionDeCorreo -> {
                        correos.add(Correo.builder()
                            .correo(direccionDeCorreo)
                            .estudiante(estudiante)
                            .build());
                    
                });

            estudiante.setCorreos(correos);

        }
                estudianteService.persistirEstudiante(estudiante);
                return "redirect:/all";
            }


}
