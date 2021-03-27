package com.example.histoclin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.histoclin.entity.Pregunta;
import com.example.histoclin.persitencia.ValoracionDAO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistroValoracionActivity extends AppCompatActivity {

    @BindView(R.id.pregunta_1_valoracion)
    TextView pregunta1;
    @BindView(R.id.respuesta_1_valoracion)
    EditText respuesta1;

    @BindView(R.id.pregunta_2_valoracion)
    TextView pregunta2;
    @BindView(R.id.respuesta_2_valoracion)
    EditText respuesta2;

    @BindView(R.id.pregunta_3_valoracion)
    TextView pregunta3;
    @BindView(R.id.respuesta_3_valoracion)
    EditText respuesta3;

    @BindView(R.id.observaciones_valoracion)
    TextView observacion;
    @BindView(R.id.respuesta_obsevaciones_valoracion)
    EditText respuestaobservacion;

    @BindView(R.id.btn_guardar_valoracion)
    Button guardar;
    @BindView(R.id.btn_cancelar_valoracion)
    Button cancelar;
    @BindView(R.id.nombre_paciente_valoracion)
    TextView nombre;

    private ValoracionDAO valoracionDAO = new ValoracionDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_valoracion);
        ButterKnife.bind(this);
        Intent inten =getIntent();
        nombre.setText(inten.getStringExtra("nombre_paciente"));

        guardar.setOnClickListener(v -> {
            valoracionDAO.guargar(inten.getStringExtra("documento_paciente"),llenarPreguntas());
            goToMain();
        });

        cancelar.setOnClickListener(v -> goToMain());

    }

    private List<Pregunta> llenarPreguntas(){
        List<Pregunta> preguntas= new ArrayList<>();
        preguntas.add(new Pregunta(pregunta1.getText().toString(),respuesta1.getText().toString()));
        preguntas.add(new Pregunta(pregunta3.getText().toString(),respuesta2.getText().toString()));
        preguntas.add(new Pregunta(pregunta3.getText().toString(),respuesta3.getText().toString()));
        preguntas.add(new Pregunta(observacion.getText().toString(),respuestaobservacion.getText().toString()));
        return preguntas;
    }

    private void goToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}