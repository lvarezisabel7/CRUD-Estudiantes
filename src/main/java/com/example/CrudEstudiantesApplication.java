package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Genero;
import com.example.entities.Horario;
import com.example.entities.Telefono;
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

		cursoService.persistirCurso(curso1);
		cursoService.persistirCurso(curso2);
		cursoService.persistirCurso(curso3);
		


		// Creamos los Estudiantes

		Estudiante est1 = Estudiante.builder()
		.nombre("Pepa")
		.primerApellido("Gonzalez")
		.segundoApellido("Gimenez")
		.genero(Genero.MUJER)
		.fechaMatriculacion(LocalDate.of(2023, Month.SEPTEMBER, 1))
		.totalAsignaturasMatriculadas(8)
		.build();

		Estudiante est2 = Estudiante.builder()
		.nombre("Andrea")
		.primerApellido("Dos Santos")
		.segundoApellido("Teixeira")
		.genero(Genero.MUJER)
		.fechaMatriculacion(LocalDate.of(2023, Month.SEPTEMBER, 1))
		.totalAsignaturasMatriculadas(8)
		.build();

		Estudiante est3 = Estudiante.builder()
		.nombre("Juan")
		.primerApellido("Rodriguez")
		.segundoApellido("Sanchez")
		.genero(Genero.HOMBRE)
		.fechaMatriculacion(LocalDate.of(2023, Month.SEPTEMBER, 12))
		.totalAsignaturasMatriculadas(6)
		.build();

		Estudiante est4 = Estudiante.builder()
		.nombre("Luisa")
		.primerApellido("Montoro")
		.segundoApellido("Navarro")
		.genero(Genero.MUJER)
		.fechaMatriculacion(LocalDate.of(2023, Month.SEPTEMBER, 1))
		.totalAsignaturasMatriculadas(8)
		.build();

		Estudiante est5 = Estudiante.builder()
		.nombre("Jesus")
		.primerApellido("Duque")
		.segundoApellido("Martinez")
		.genero(Genero.HOMBRE)
		.fechaMatriculacion(LocalDate.of(2023, Month.SEPTEMBER, 3))
		.totalAsignaturasMatriculadas(4)
		.build();

		Estudiante est6 = Estudiante.builder()
		.nombre("Martina")
		.primerApellido("Canovas")
		.segundoApellido("Rivera")
		.genero(Genero.MUJER)
		.fechaMatriculacion(LocalDate.of(2023, Month.SEPTEMBER, 3))
		.totalAsignaturasMatriculadas(5)
		.build();

		estudianteService.persistirEstudiante(est1);
		estudianteService.persistirEstudiante(est2);
		estudianteService.persistirEstudiante(est3);
		estudianteService.persistirEstudiante(est4);
		estudianteService.persistirEstudiante(est5);
		estudianteService.persistirEstudiante(est6);

		// Creamos los Telefonos
		

		Telefono tel1Estudiante1 = Telefono.builder()
			.telefono("636871638")
			.estudiante(estudianteService.dameUnEstudiante(1))
			.build();
		
		Telefono tel2Estudiante1 = Telefono.builder()
			.telefono("650338106")
			.estudiante(estudianteService.dameUnEstudiante(1))
			.build();
		
		Telefono tel1Estudiante2 = Telefono.builder()
			.telefono("717119149")
			.estudiante(estudianteService.dameUnEstudiante(2))
			.build();
		
		Telefono tel1Estudiante3 = Telefono.builder()
			.telefono("679323246")
			.estudiante(estudianteService.dameUnEstudiante(3))
			.build();
		
		Telefono tel2Estudiante3 = Telefono.builder()
			.telefono("636871638")
			.estudiante(estudianteService.dameUnEstudiante(3))
			.build();
		
		Telefono tel1Estudiante4 = Telefono.builder()
			.telefono("650338106")
			.estudiante(estudianteService.dameUnEstudiante(4))
			.build();
		
		Telefono tel1Estudiante5 = Telefono.builder()
			.telefono("717119149")
			.estudiante(estudianteService.dameUnEstudiante(5))
			.build();
		
		Telefono tel1Estudiante6 = Telefono.builder()
			.telefono("679323246")
			.estudiante(estudianteService.dameUnEstudiante(6))
			.build();
		
		telefonoService.persistirTelefono(1, tel1Estudiante1);
		telefonoService.persistirTelefono(1, tel2Estudiante1);
		telefonoService.persistirTelefono(2, tel1Estudiante2);
		telefonoService.persistirTelefono(3, tel1Estudiante3);
		telefonoService.persistirTelefono(3, tel2Estudiante3);
		telefonoService.persistirTelefono(4, tel1Estudiante4);
		telefonoService.persistirTelefono(5, tel1Estudiante5);
		telefonoService.persistirTelefono(6, tel1Estudiante6);
		
	}

	

	

}
