package com.example.edical.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edical.MainActivity;
import com.example.edical.R;
import com.google.firebase.auth.FirebaseAuth;

public class Portada extends AppCompatActivity {

    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.barraProgreso_por);
        progressBar.setVisibility(View.GONE);

        if(auth.getCurrentUser()!=null){
            progressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(Portada.this, MainActivity.class));
            Toast.makeText(this, "Por favor espera, hay una sesión abierta", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void Ingreso_por(View view){
        startActivity(new Intent(Portada.this, IngresoActivity.class));
    }

    public void Registro_por(View view){
        startActivity(new Intent(Portada.this, RegistroActivity.class));
    }

}