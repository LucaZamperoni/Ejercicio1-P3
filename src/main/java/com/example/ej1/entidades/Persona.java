package com.example.ej1.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity // Anotación que marca esta clase como una entidad JPA
@Data // Anotación para generar automáticamente los métodos básicos de acceso a los campos
@AllArgsConstructor // Anotación para generar un constructor que incluye todos los campos de la clase
@NoArgsConstructor // Anotación para generar un constructor vacío

/*
Anotación para permitir la creación de objetos utilizando un patrón de diseño "Builder":
En lugar de llamar al constructor directamente y proporcionar todos los argumentos,
puedes usar el builder generado para establecer los valores de los campos de manera más legible y estructurada.
 */
@Builder

public class Persona implements Serializable {

    // Indica que este campo es la clave primaria de la entidad y se generará automáticamente
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
}
