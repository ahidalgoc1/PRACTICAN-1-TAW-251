package com.universidad.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//decoradores
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;         
}
