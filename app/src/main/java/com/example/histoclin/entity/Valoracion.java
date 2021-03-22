package com.example.histoclin.entity;

import java.util.List;

public class Valoracion {

    private long idValoracion;
    private List<Pregunta> preguntas;
    private String documentoPaciente;

    public Valoracion(long idValoracion, String documentoPaciente, List<Pregunta> preguntas) {
        this.idValoracion = idValoracion;
        this.preguntas = preguntas;
        this.documentoPaciente = documentoPaciente;
    }
}
