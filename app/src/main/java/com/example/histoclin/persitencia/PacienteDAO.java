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
    List<Paciente> pacientes = pacienteMOCK.getPaciente();





    public boolean agregarPaciente(String documento, String nombre, String apellido, LocalDate fechaNacimiento){


        Paciente pacienteAgregar = new Paciente(pacientes.size()+1,documento,nombre,apellido,fechaNacimiento);
        if(pacienteExiste(documento)){
            return false;
        }else{

            pacienteMOCK.getPaciente().add(pacienteAgregar);
            return true;
        }

    }

    public Paciente buscar(String documento){
        for (int i = 0; i<pacientes.size();i++){
            if(pacientes.get(i).getDocumento().equals(documento)){
               return pacientes.get(i);
            }
        }
        return null;
    }

    private boolean pacienteExiste(String documento){

        return buscar(documento) != null ? true : false;

    }



}
