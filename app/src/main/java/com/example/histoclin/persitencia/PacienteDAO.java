package com.example.histoclin.persitencia;

import com.example.histoclin.entity.Paciente;
import com.example.histoclin.mock.PacienteMOCK;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PacienteDAO {
    PacienteMOCK pacienteMOCK = new PacienteMOCK();

    public boolean agregarPaciente(String documento, String nombre, String apellido, LocalDate fechaNacimiento){
        Paciente pacienteAgregar = new Paciente( pacienteMOCK.pacientes.size()+1,documento,nombre,apellido,fechaNacimiento);
        if(pacienteExiste(documento)){
            return false;
        }else{
            pacienteMOCK.pacientes.add(pacienteAgregar);
            return true;
        }

    }

    public Paciente buscar(String documento){

        for (int i = 0; i< pacienteMOCK.pacientes.size();i++){
            if( pacienteMOCK.pacientes.get(i).getDocumento().equals(documento)){
               return  pacienteMOCK.pacientes.get(i);
            }
        }
        return null;
    }

    private boolean pacienteExiste(String documento){

        return buscar(documento) != null ? true : false;

    }



}
