package com.example.histoclin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_iniciar_login)
    Button btnIniciar;

    @BindView(R.id.nombre_usuario_login)
    TextView nombreUsuario;

    @BindView(R.id.contrasena_usuario)
    TextView contrasenaUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

       btnIniciar.setOnClickListener(v -> {
            if(verificarDatos(nombreUsuario.getText().toString(),contrasenaUsuario.getText().toString())){
                goToMain(nombreUsuario.getText().toString());
            }else{
                Toast.makeText(this, R.string.datos_incorrectos, Toast.LENGTH_LONG ).show();
            }

        });

    }

    private boolean verificarDatos(String nombreUsuario, String contrasena){

        return  nombreUsuario.equals(contrasena);

    }

    private void goToMain(String nombreUsuario){
        Intent intent =new Intent(this,MainActivity.class);
        intent.putExtra("nombre_usuario",nombreUsuario);
        startActivity(intent);
    }
}