package com.example.histoclin.persitencia;

import androidx.annotation.NonNull;

import com.example.histoclin.entity.Paciente;
import com.example.histoclin.fabrica.PacienteFabrica;
import com.example.histoclin.mock.PacienteMOCK;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.joda.time.LocalDate;

public class PacienteDAO {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    PacienteFabrica pacienteFabrica = new PacienteFabrica();
    public boolean agregarPaciente(String documento, String nombre, String apellido, LocalDate fechaNacimiento){
        ListarPacientes();
        Paciente pacienteAgregar = new Paciente((long) (PacienteMOCK.pacientes.size()+1),documento,nombre,apellido,fechaNacimiento);
        if(pacienteExiste(documento)){
            return false;
        }else{


            PacienteFirebase pacienteFirebase = pacienteFabrica.PacienteToFirebase(pacienteAgregar);
            myRef.child("Paciente").child(pacienteFirebase.getDocumento()).setValue(pacienteFirebase);
            ListarPacientes();
            return true;
        }

    }

    public void ListarPacientes() {
        myRef.child("Paciente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PacienteMOCK.pacientes.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Paciente paciente = pacienteFabrica.FirebaseToPaciente(dataSnapshot.getValue(PacienteFirebase.class));
                    PacienteMOCK.pacientes.add(paciente);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public Paciente buscar(String documento){

        for (int i = 0; i< PacienteMOCK.pacientes.size();i++){
            if( PacienteMOCK.pacientes.get(i).getDocumento().equals(documento)){
               return  PacienteMOCK.pacientes.get(i);
            }
        }
        return null;
    }

    private boolean pacienteExiste(String documento){
        return buscar(documento) != null ? true : false;

    }



}
