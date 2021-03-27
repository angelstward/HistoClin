package com.example.histoclin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.histoclin.persitencia.PacienteDAO;

import org.joda.time.LocalDate;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrarPacienteActivity extends AppCompatActivity {

    @BindView(R.id.documento_registro_pacientes)
    EditText documentoRegistro;

    @BindView(R.id.nombre_registro_pacientes)
    EditText nombreRegistro;

    @BindView(R.id.apellido_registro_pacientes)
    EditText apellidoRegistro;

    @BindView(R.id.btn_registrar_fecha)
    Button btnRegistrarFecha;

    @BindView(R.id.fecha_nacimiento_registrar_pacientes)
    TextView fecha;

    @BindView(R.id.crear_registro_pacientes)
    Button btnRegistrar;

    @BindView(R.id.cancelar_registro_pacientes)
    Button btnCancelar;

    final int TIME_ID = 0;
    int ano, mes, dia;
    private Calendar fechaNacimientoCalendar = Calendar.getInstance();
    private LocalDate fechaGuardar;
    private PacienteDAO pacienteDAO=new PacienteDAO();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente);
        ButterKnife.bind(this);

       btnRegistrarFecha.setOnClickListener(v -> {
           dia = fechaNacimientoCalendar.get(Calendar.DAY_OF_MONTH);
           mes = fechaNacimientoCalendar.get(Calendar.MONTH);
           ano = fechaNacimientoCalendar.get(Calendar.YEAR);

           DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
               @Override
               public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                   fecha.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                   fechaGuardar=new LocalDate(year,(month+1),dayOfMonth);
               }
           },dia,mes,ano);
           datePickerDialog.show();
       });

       btnRegistrar.setOnClickListener(v -> {

        if(validarCampos()){
            if (pacienteDAO.agregarPaciente(documentoRegistro.getText().toString(), nombreRegistro.getText().toString(),
                    apellidoRegistro.getText().toString(), fechaGuardar)) {
                goToMain();
            } else {
                Toast.makeText(this, R.string.paciente_ya_existe, Toast.LENGTH_LONG).show();
            }
        }

       });

       btnCancelar.setOnClickListener(v -> goToMain());

    }

    private void goToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
     private boolean validarCampos(){
        if(documentoRegistro.getText().toString().isEmpty() || documentoRegistro.equals(null)){
            Toast.makeText(this, R.string.documeto_vacio, Toast.LENGTH_LONG).show();
            return false;
        }else if(nombreRegistro.getText().toString().isEmpty()|| nombreRegistro.equals(null)){
            Toast.makeText(this, R.string.nombre_vacio, Toast.LENGTH_LONG).show();
            return false;
        }else if(apellidoRegistro.getText().toString().isEmpty() || apellidoRegistro.equals(null)){
            Toast.makeText(this, R.string.apellido_vacio, Toast.LENGTH_LONG).show();
            return false;
        }else if(fecha.getText().toString().isEmpty()|| fecha.equals(null)){
            Toast.makeText(this, R.string.fecha_vacia, Toast.LENGTH_LONG).show();
            return false;
        }else{

            return true;
        }


     }

}