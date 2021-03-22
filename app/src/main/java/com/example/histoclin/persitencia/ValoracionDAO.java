package com.example.histoclin.persitencia;

import com.example.histoclin.entity.Pregunta;
import com.example.histoclin.entity.Valoracion;

import java.util.ArrayList;
import java.util.List;

public class ValoracionDAO {
    List<Valoracion> valoraciones = new ArrayList<>();

    public void guargar(String documentoPaciente, List<Pregunta>preguntas) {
        Valoracion valoracion = new Valoracion((valoraciones.size()+1),documentoPaciente,preguntas);
        valoraciones.add(valoracion);
    }
}
