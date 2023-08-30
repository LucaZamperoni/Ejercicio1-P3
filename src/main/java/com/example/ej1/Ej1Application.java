package com.example.ej1;

import com.example.ej1.entidades.Persona;
import com.example.ej1.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// Anotación que marca esta clase como la clase principal de la aplicación Spring Boot.
@SpringBootApplication
public class Ej1Application {

	// Inyección de dependencia del repositorio de Persona.
	@Autowired
	PersonaRepositorio personaRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(Ej1Application.class, args);
		System.out.println("La Aplicación funciona!");
	}

	/*
	En el contexto de Spring Framework, un "bean" es simplemente un objeto gestionado por el contenedor de Spring.
	Puede ser cualquier clase Java que Spring instancie, configure y administre.
	Los beans son los componentes fundamentales que componen una aplicación de Spring, y Spring se encarga de administrar su ciclo de vida y sus dependencias.
	Los beans en Spring se definen mediante anotaciones como @Component, @Service, @Repository, @Controller, etc.
	Estas anotaciones le indican a Spring que una clase en particular debe ser tratada como un bean y ser gestionada por el contenedor de Spring.
	Los beans pueden ser inyectados en otras partes de la aplicación, lo que permite una gestión más eficiente de las dependencias y la configuración.
	 */
	@Bean
	/*
	CommandLineRunner es una interfaz funcional proporcionada por Spring Boot que se utiliza para ejecutar tareas al inicio de una aplicación Spring Boot,
	justo después de que el contexto de Spring se haya cargado por completo.
	 */
	CommandLineRunner init(PersonaRepositorio personaRepositorio) {
		return args -> {
			System.out.println("Bean Funcionando");
			Persona persona = new Persona();
			persona.setNombre("Juan");
			persona.setApellido("Pérez");
			persona.setEdad(30);

			// Guardar el objeto Persona en la base de datos utilizando el repositorio.
			personaRepositorio.save(persona);

			// Recuperar el objeto Persona desde la base de datos.
			Persona personaRecuperada = personaRepositorio.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
			}
		};
	}

}
