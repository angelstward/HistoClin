package com.example.histoclin.persitencia;

import com.example.histoclin.entity.Pregunta;
import com.example.histoclin.entity.Valoracion;
import com.example.histoclin.mock.ValoracionMock;

import java.util.ArrayList;
import java.util.List;

public class ValoracionDAO {

    public void guargar(String documentoPaciente, List<Pregunta>preguntas) {
        Valoracion valoracion = new Valoracion(ValoracionMock.valoraciones.size()+1,documentoPaciente,preguntas);
        ValoracionMock.valoraciones.add(valoracion);
    }
}
