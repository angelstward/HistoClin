package com.example.histoclin.persitencia;

import com.example.histoclin.entity.Paciente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacienteDAO {

    private Paciente paciente1= new Paciente(1,"1234","Carlos","Julano");
    private Paciente paciente2= new Paciente(2,"12345","Alberto","Perabo");
    private  Paciente paciente3= new Paciente(3,"123456","Roberto","Santa");

    private List<Paciente> pacientes = Arrays.asList(paciente1,paciente2,paciente3);


    public void agregarPaciente(String documento, String nombre, String apellido){
        Paciente pacienteAgregar = new Paciente(pacientes.size()+1,documento,nombre,apellido);
        pacientes.add(pacienteAgregar);
    }

    public Paciente buscar(String documento){
        for (int i = 0; i<pacientes.size();i++){
            if(pacientes.get(i).getDocumento().equals(documento)){
               return pacientes.get(i);
            }
        }
        return null;
    }

}
