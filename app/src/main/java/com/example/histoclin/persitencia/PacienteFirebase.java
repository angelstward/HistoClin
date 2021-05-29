package com.example.histoclin.persitencia;

import lombok.Data;

@Data
public class PacienteFirebase {
    private String Id;
    private String documento;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
}
