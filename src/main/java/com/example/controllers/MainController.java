package com.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
import com.example.entities.Curso;
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

            // Eliminar estudiantes
            @GetMapping("/eliminar/{id}")
            @Transactional
            public String eliminarEstudiante(@PathVariable(name = "id", required = true) int idEstudiante) {
                
                estudianteService.eliminarEstudiante(idEstudiante);
        
                return "redirect:/all";
            }

            // Actualizar estudiantes
            @GetMapping("/modificar/{id}")
            public String actualizarEstudiante(@PathVariable(name = "id", required = true) int idEstudiante, Model model) {

                // Primero tengo que recuperar el estudiante del que se manda el id
                Estudiante estudiante = estudianteService.dameUnEstudiante(idEstudiante);
                model.addAttribute("estudiante", estudiante);

                // Recuperamos los cursos
                List<Curso> cursos = cursoService.dameCursos();   
                model.addAttribute("curso", cursos);
                
                // Construir los numeros de telefono (separados por ;), a partir de los tlfn recibidos conjuntamente con el estudiante
                if(estudiante.getTelefonos() != null) {
                    String numerosTelefono = estudiante.getTelefonos().stream()
                        .map(Telefono::getTelefono)
                        .collect(Collectors.joining(";"));
                    model.addAttribute("numerosTelefono", numerosTelefono);

                }

                 // Construir los correos (separados por ;), a partir de los correos recibidos conjuntamente con el estudiante
                 if(estudiante.getCorreos() != null) {
                    String direccionesDeCorreo = estudiante.getCorreos().stream()
                        .map(Correo::getCorreo)
                        .collect(Collectors.joining(";"));
                    model.addAttribute("direccionesDeCorreo", direccionesDeCorreo);

                }
                return "views/frmAltaModificacionEstudiante";
            }


}
