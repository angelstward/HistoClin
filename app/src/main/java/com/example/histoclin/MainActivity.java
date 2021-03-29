package com.example.histoclin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
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

    @BindView(R.id.nombre_usuario_main)
    TextView nombreUsuarioTitulo;

    @BindView(R.id.cerrar_sesion)
    TextView cerrarSesion;

    @BindView(R.id.btn_registrar_paciente)
    Button registrarPaciente;

    private List<Paciente> listaPacientes = new ArrayList<>();
    private PacienteAdapter pacienteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        cerrarSesion.setClickable(true);
        Intent intent = getIntent();
        nombreUsuarioTitulo.setText(intent.getStringExtra("nombre_usuario"));

        cerrarSesion.setOnClickListener(v -> goToLogin() );

        buscar.setOnClickListener(v -> {
            cargarPaciente(documetoIngresado.getText().toString());

        });

        registrarPaciente.setOnClickListener(v -> goToRegistrarPacienet());

        listViewPacientes.setClickable(true);
        listViewPacientes.setOnItemClickListener((parent, view, position, id) ->{

            Paciente pacienteSeleccionado = (Paciente) listViewPacientes.getItemAtPosition(position);
            goToRegistroValoracion(pacienteSeleccionado.getDocumento(), pacienteSeleccionado.getNombre(), pacienteSeleccionado.getApellido());


        });




    }

    private void cargarPaciente(String documento){
        listaPacientes.clear();
        PacienteDAO pacienteDAO =new PacienteDAO();
        Paciente paciente = pacienteDAO.buscar(documento);



        if(paciente==null){
            Toast.makeText(this, R.string.paciente_no_encontrado, Toast.LENGTH_LONG ).show();
        }else {
            listaPacientes.add(paciente);
            pacienteAdapter = new PacienteAdapter(this,listaPacientes);
            listViewPacientes.setAdapter(pacienteAdapter);
        }

    }
    private void goToRegistrarPacienet(){
        Intent intent =new Intent(this,RegistrarPacienteActivity.class) ;
        startActivity(intent);
        finish();
    }

    private void goToRegistroValoracion(String documento, String nombre, String apellido){
        Intent intent = new Intent(this, RegistroValoracionActivity.class);
        intent.putExtra("documento_paciente",documento);
        intent.putExtra("nombre_paciente",nombre);
        intent.putExtra("apellido_paciente",apellido);
        startActivity(intent);
        finish();
    }

    private void goToLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed (){

    }

}