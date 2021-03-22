package com.example.histoclin.persitencia;

import com.example.histoclin.entity.Paciente;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PacienteDAO {

    private LocalDate fecha=  new LocalDate(1998,1,12);
    private Paciente paciente1= new Paciente(1,"1234","Carlos","Julano", fecha);
    private Paciente paciente2= new Paciente(2,"12345","Alberto","Perabo",fecha);
    private  Paciente paciente3= new Paciente(3,"123456","Roberto","Santa",fecha);


    private List<Paciente> pacientes = Arrays.asList(paciente1,paciente2,paciente3);


    public boolean agregarPaciente(String documento, String nombre, String apellido, LocalDate fechaNacimiento){
        Paciente pacienteAgregar = new Paciente(pacientes.size()+1,documento,nombre,apellido,fechaNacimiento);
        if(pacienteExiste(documento)){
            return false;
        }else{
            pacientes.add(pacienteAgregar);
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
