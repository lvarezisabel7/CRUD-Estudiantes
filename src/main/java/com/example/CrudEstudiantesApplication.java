package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Genero;
import com.example.entities.Horario;
import com.example.services.CorreoService;
import com.example.services.CursoService;
import com.example.services.EstudianteService;
import com.example.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudEstudiantesApplication implements CommandLineRunner{

	private final EstudianteService estudianteService;
	private final CursoService cursoService;
	private final TelefonoService telefonoService;
	private final CorreoService correoService;

	public static void main(String[] args) {
		SpringApplication.run(CrudEstudiantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Primero creamos los cursos

		Curso curso1 = Curso.builder()
		.descripcion("PRIMER CURSO")
		.horario(Horario.DIURNO)
		.build();

		Curso curso2 = Curso.builder()
		.descripcion("SEGUNDO CURSO")
		.horario(Horario.NOCTURNO)
		.build();

		Curso curso3 = Curso.builder()
		.descripcion("TERCER CURSO")
		.horario(Horario.DIURNO)
		.build();

		Curso curso4 = Curso.builder()
		.descripcion("CUARTO CURSO")
		.horario(Horario.NOCTURNO)
		.build();

		cursoService.persistirCurso(curso1);
		cursoService.persistirCurso(curso2);
		cursoService.persistirCurso(curso3);
		cursoService.persistirCurso(curso4);
	}

	

	

}
