package com.example.histoclin.entity;

import lombok.Data;

@Data
public class Pregunta {

    private String pregunta;
    private  String respuesta;

    public Pregunta(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
}
