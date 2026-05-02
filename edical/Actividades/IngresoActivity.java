package com.example.edical.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.edical.MainActivity;
import com.example.edical.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class IngresoActivity extends AppCompatActivity {

    Button Ingreso;
    EditText correo, contraseña;
    TextView Registro;

    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressBar = findViewById(R.id.barraProgreso_ing);
        progressBar.setVisibility(View.GONE);

        Ingreso = findViewById(R.id.Ingresa_btn);
        correo = findViewById(R.id.Email_log);
        contraseña = findViewById(R.id.Contrasena_log);
        Registro = findViewById(R.id.Registro_log);

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IngresoActivity.this, RegistroActivity.class));
            }
        });

        Ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IngresoUsuario();
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void IngresoUsuario() {

        String correoUsuario = correo.getText().toString();
        String contrasenaUsuario = contraseña.getText().toString();

        if (TextUtils.isEmpty(correoUsuario)){
            Toast.makeText(this,"Correo en vacío!",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(contrasenaUsuario)){
            Toast.makeText(this,"Contraseña en vacío!",Toast.LENGTH_SHORT).show();
            return;
        }

        if (contrasenaUsuario.length() < 6){
            Toast.makeText(this,"Contraseña debe ser mayor a 6 caracteres!",Toast.LENGTH_SHORT).show();
            return;
        }
        //Ingreso Usuario
        auth.signInWithEmailAndPassword(correoUsuario,contrasenaUsuario)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(IngresoActivity.this,"Ingreso Satisfactorio!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(IngresoActivity.this, MainActivity.class));
                            finish();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(IngresoActivity.this, "Error "+task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}