package com.example.histoclin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    public  static final int REQUEST_CODE= 4561;

    List<AuthUI.IdpConfig> provider = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build()

    );

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
        mAuth = FirebaseAuth.getInstance();

        ButterKnife.bind(this);

       btnIniciar.setOnClickListener(v -> {
            if(verificarDatos(nombreUsuario.getText().toString(),contrasenaUsuario.getText().toString())){
                SingIn(nombreUsuario.getText().toString(),contrasenaUsuario.getText().toString());
            }else{
                Toast.makeText(this, R.string.campos_vacios_login, Toast.LENGTH_LONG ).show();
            }

        });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        Log.i("Usuario",""+currentUser);
    }
    public void SingIn(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("EXITO", "Inicio correcto");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            goToMain(email);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("ERROR", "Fallo en login", task.getException());
                            Toast.makeText(LoginActivity.this, "Credenciales incorrectas.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }


    private boolean verificarDatos(String nombreUsuario, String contrasena){
        return  !nombreUsuario.isEmpty() || !contrasena.isEmpty();
    }

    private void goToMain(String nombreUsuario){
        Intent intent =new Intent(this,MainActivity.class);
        intent.putExtra("nombre_usuario",nombreUsuario);
        startActivity(intent);
    }
}