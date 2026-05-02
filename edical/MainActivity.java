package com.example.edical;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.edical.Actividades.IngresoActivity;
import com.example.edical.Actividades.Portada;
import com.example.edical.Actividades.RegistroActivity;
import com.example.edical.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

/**
 * Actividad principal de la aplicación que gestiona la navegación lateral (Navigation Drawer)
 * y la configuración de los fragmentos principales.
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Uso de View Binding para acceder a los componentes de la interfaz
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuración de la barra de herramientas (Toolbar)
        setSupportActionBar(binding.appBarMain.toolbar);

        // Configuración del botón flotante (FAB)
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad de registro al hacer clic
                startActivity(new Intent(MainActivity.this, RegistroActivity.class));
                Snackbar.make(view, "Cambiando a Registro", Snackbar.LENGTH_LONG)
                        .setAction("Acción", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configuración de los destinos principales de navegación
        // Cada ID de menú se considera un destino de nivel superior
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_perfil, R.id.nav_categoria, R.id.nav_miOrden, R.id.nav_miCarrito,
                R.id.nav_oferta, R.id.nav_nuevoProducto)
                .setOpenableLayout(drawer)
                .build();

        // Configuración del controlador de navegación (NavController)
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /**
     * Infla el menú de opciones en la barra superior.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Gestiona la navegación hacia atrás o hacia arriba.
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
