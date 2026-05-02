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

import com.example.edical.R;
import com.example.edical.modelo.UsuarioModelo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Actividad encargada de gestionar el registro de nuevos usuarios.
 * Utiliza Firebase Authentication para la creación de cuentas y Realtime Database para almacenar datos adicionales.
 */
public class RegistroActivity extends AppCompatActivity {

    // Botón para iniciar el proceso de registro
    Button registro;
    // Campos de entrada para el nombre, correo y contraseña
    EditText nombre, correo, contraseña;
    // Texto que redirige a la pantalla de inicio de sesión
    TextView Ingreso;
    // Instancia de FirebaseAuth para gestionar la autenticación
    FirebaseAuth auth;
    // Instancia de FirebaseDatabase para guardar la información del usuario
    FirebaseDatabase database;
    // Barra de progreso para indicar que se está procesando el registro
    ProgressBar progressBar;

    /**
     * Método que se ejecuta al crear la actividad. Inicializa los componentes de la interfaz
     * y configura los escuchadores de clics.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Inicialización de las instancias de Firebase
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        // Configuración inicial de la barra de progreso (oculta por defecto)
        progressBar = findViewById(R.id.barraProgreso_reg);
        progressBar.setVisibility(View.GONE);

        // Vinculación de los elementos de la interfaz con las variables
        registro = findViewById(R.id.Login_btn);
        nombre = findViewById(R.id.Nombre_reg);
        correo = findViewById(R.id.Email_reg);
        contraseña = findViewById(R.id.Contrasena_reg);
        Ingreso = findViewById(R.id.Inicia_reg);

        /**
         * Listener para el texto de "Ingreso". Redirige al usuario a la pantalla de Login.
         */
        Ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistroActivity.this, IngresoActivity.class));
            }
        });

        /**
         * Listener para el botón de registro. Valida los datos e intenta crear el usuario.
         */
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearUsuario();
                // Muestra la barra de progreso al iniciar la petición
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * Extrae los datos de los campos de texto, valida que no estén vacíos
     * e intenta registrar al usuario en Firebase.
     */
    private void crearUsuario() {

        String nombreUsuario = nombre.getText().toString();
        String correoUsuario = correo.getText().toString();
        String contrasenaUsuario = contraseña.getText().toString();

        // Validación: Nombre obligatorio
        if (TextUtils.isEmpty(nombreUsuario)){
            Toast.makeText(this,"Nombre en vacío!",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        // Validación: Correo obligatorio
        if (TextUtils.isEmpty(correoUsuario)){
            Toast.makeText(this,"Correo en vacío!",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        // Validación: Contraseña obligatoria
        if (TextUtils.isEmpty(contrasenaUsuario)){
            Toast.makeText(this,"Contraseña en vacío!",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        // Validación: Longitud mínima de la contraseña
        if (contrasenaUsuario.length() < 6){
            Toast.makeText(this,"Contraseña debe ser mayor a 6 caracteres!",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        /**
         * Llama a Firebase Auth para crear la cuenta con email y contraseña.
         */
        auth.createUserWithEmailAndPassword(correoUsuario,contrasenaUsuario)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            // Si el registro es exitoso, crea un modelo de usuario para guardar en la DB
                            UsuarioModelo usuarioModelo=new UsuarioModelo(nombreUsuario,correoUsuario,contrasenaUsuario);
                            String id = task.getResult().getUser().getUid();
                            
                            // Guarda los datos del usuario en el nodo "Usuarios" usando su UID
                            database.getReference().child("Usuarios").child(id).setValue(usuarioModelo);
                            
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(RegistroActivity.this,"Registro Satisfactorio",Toast.LENGTH_SHORT).show();
                            
                            // Aquí podrías redirigir a la pantalla principal si lo deseas
                        }
                        else {
                            // En caso de error, oculta el progreso y muestra el mensaje de fallo
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(RegistroActivity.this,"Error "+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
