package com.example.histoclin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.histoclin.adapter.PacienteAdapter;
import com.example.histoclin.entity.Paciente;
import com.example.histoclin.persitencia.PacienteDAO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.list_view_paciente)
    ListView  listViewPacientes;

    @BindView(R.id.btn_buscar_main)
    ImageButton buscar;

    @BindView(R.id.ingreasar_documento_main)
    EditText documetoIngresado;

    private List<Paciente> listaPacientes = new ArrayList<>();
    private PacienteAdapter pacienteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        buscar.setOnClickListener(v -> {
            cargarPaciente(documetoIngresado.getText().toString());

        });


    }

    private void cargarPaciente(String documento){
        listaPacientes.clear();
        PacienteDAO pacienteDAO =new PacienteDAO();
        Paciente paciente = pacienteDAO.buscar(documento);



        if(paciente==null){
            Toast.makeText(getApplicationContext(), R.string.paciente_no_encontrado,Toast.LENGTH_LONG);
        }else {
            listaPacientes.add(paciente);
            pacienteAdapter = new PacienteAdapter(this,listaPacientes);
            listViewPacientes.setAdapter(pacienteAdapter);
        }

    }
}