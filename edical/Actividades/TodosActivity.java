package com.example.edical.Actividades;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.edical.R;

/**
 * Actividad que muestra una vista general (posiblemente de todos los productos).
 * Implementa un diseño de borde a borde (Edge-to-Edge) para una experiencia visual inmersiva.
 */
public class TodosActivity extends AppCompatActivity {

    /**
     * Método de ciclo de vida que se llama cuando se crea la actividad por primera vez.
     * Aquí se inicializa la interfaz y se configuran los ajustes visuales.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Habilita el modo "Edge-to-Edge" para que el contenido se extienda detrás de las barras del sistema
        EdgeToEdge.enable(this);
        
        // Establece el diseño de la actividad desde el archivo XML activity_todos.xml
        setContentView(R.layout.activity_todos);
        
        // Configura un listener para manejar los márgenes (insets) de las barras del sistema (estado y navegación)
        // Esto evita que el contenido sea tapado por los elementos del sistema Android.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Obtiene los márgenes de las barras del sistema
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            
            // Aplica los márgenes como padding a la vista principal para que el contenido se vea correctamente
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            
            return insets;
        });
    }
}
