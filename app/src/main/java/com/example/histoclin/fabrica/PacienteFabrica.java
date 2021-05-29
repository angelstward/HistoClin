package com.example.histoclin.fabrica;

import com.example.histoclin.entity.Paciente;
import com.example.histoclin.persitencia.PacienteDAO;
import com.example.histoclin.persitencia.PacienteFirebase;

import org.joda.time.LocalDate;
public class PacienteFabrica {

    public PacienteFirebase PacienteToFirebase(Paciente paciente){
        PacienteFirebase pacienteFirebase= new PacienteFirebase();
        pacienteFirebase.setId(String.valueOf(paciente.getId()));
        pacienteFirebase.setDocumento(String.valueOf(paciente.getDocumento()));
        pacienteFirebase.setNombre(String.valueOf(paciente.getNombre()));
        pacienteFirebase.setApellido(String.valueOf(paciente.getApellido()));
        pacienteFirebase.setFechaNacimiento(String.valueOf(paciente.getFechaNacimiento()));
        return pacienteFirebase;
    }

    public Paciente FirebaseToPaciente(PacienteFirebase pacienteFirebase){
        return new Paciente(Long.valueOf(pacienteFirebase.getId()),pacienteFirebase.getDocumento(), pacienteFirebase.getNombre(), pacienteFirebase.getApellido(), convertToDate(pacienteFirebase.getFechaNacimiento()));


    }

    private LocalDate convertToDate(String fecha){
        int anio = Integer.parseInt(fecha.substring(0,4));
        int mes = Integer.parseInt(fecha.substring(5,7));
        int dia = Integer.parseInt(fecha.substring(8));
        return new LocalDate(anio,mes,dia);
    }

}
