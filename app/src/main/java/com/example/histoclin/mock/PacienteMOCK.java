package com.example.histoclin.mock;

import com.example.histoclin.entity.Paciente;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class PacienteMOCK {

    public  List<Paciente> getPaciente(){
        List<Paciente> listaPacientes =new ArrayList<>();
        LocalDate fecha=  new LocalDate(1998,1,12);
        Paciente paciente1= new Paciente(1,"1234","Carlos","Julano", fecha);
        Paciente paciente2= new Paciente(2,"12345","Alberto","Perabo",fecha);
        Paciente paciente3= new Paciente(3,"123456","Roberto","Santa",fecha);
        listaPacientes.add(paciente1);
        listaPacientes.add(paciente2);
        listaPacientes.add(paciente3);

        return listaPacientes;
    }



}
