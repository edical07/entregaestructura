package com.example.edical.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edical.R;
import com.example.edical.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SalidaActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase database;
    TextView Salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        Salida = findViewById(R.id.action_settings);

        Salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SalidaUsuario();
                startActivity(new Intent(SalidaActivity.this, AnimaActivity.class));
            }
        });
    }

    private void SalidaUsuario() {
        //Salida Usuario
        auth.initializeRecaptchaConfig();
        auth.signOut();
        return;
    }
}
