package com.example.histoclin.entity;

import lombok.Data;

@Data
public class Paciente {

    private long id;
    private String documento;
    private String nombre;
    private String apellido;

    public Paciente(long id, String documento, String nombre, String apellido) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
