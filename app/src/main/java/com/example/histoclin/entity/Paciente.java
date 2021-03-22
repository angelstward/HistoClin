package com.example.histoclin.entity;


import org.joda.time.LocalDate;
import org.joda.time.Years;



import lombok.Data;

@Data
public class Paciente {

    private long id;
    private String documento;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Paciente(long id, String documento, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento=fechaNacimiento;
    }

    public int getEdad(){
        LocalDate fechaActual = new LocalDate();
        return Years.yearsBetween(fechaNacimiento,fechaActual).getYears();
    }
}
