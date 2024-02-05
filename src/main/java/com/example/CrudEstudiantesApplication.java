package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Estudiante;
import com.example.entities.Genero;
import com.example.services.EstudianteService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudEstudiantesApplication implements CommandLineRunner{

	private final EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(CrudEstudiantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estudiante est1 = Estudiante.builder()
				.nombre("Isabel")
				.primerApellido("Alvarez")
				.segundoApellido("Sanchez")
				.genero(Genero.MUJER)
				.build();

		estudianteService.persistirEstudiante(est1);
	}

}
