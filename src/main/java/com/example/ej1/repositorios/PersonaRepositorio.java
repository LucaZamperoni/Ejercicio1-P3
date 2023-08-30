package com.example.ej1.repositorios;

import com.example.ej1.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Esta interfaz extiende JpaRepository para proporcionar funcionalidad de acceso a datos.
// Anotación que marca esta interfaz como un repositorio de Spring.
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {

    // Esta interfaz extiende JpaRepository y se especializa para trabajar con la entidad "Persona".
    // Se indica que se trabaja con objetos de la clase "Persona" y que el tipo de la clave primaria es "Long".

    // No es necesario definir métodos aquí, ya que JpaRepository proporciona automáticamente
    // métodos para realizar operaciones CRUD (crear, leer, actualizar, eliminar) en la entidad "Persona"
    // basados en los nombres de los métodos, como "findAll", "findById", "save", "delete", etc.
}
