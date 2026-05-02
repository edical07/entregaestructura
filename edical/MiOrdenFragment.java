package com.example.edical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * Fragmento que representa la pantalla de "Mi Orden".
 * Aquí el usuario puede visualizar el historial de sus pedidos o el estado de la orden actual.
 */
public class MiOrdenFragment extends Fragment {

    /**
     * Constructor público vacío obligatorio para que Android pueda recrear el fragmento.
     */
    public MiOrdenFragment() {
        // Constructor vacío requerido
    }

    /**
     * Método que crea e infla la interfaz de usuario del fragmento.
     * 
     * @param inflater Objeto para inflar el archivo de diseño XML.
     * @param container Contenedor donde se alojará la vista del fragmento.
     * @param savedInstanceState Estado anterior guardado del fragmento.
     * @return La vista raíz del fragmento de órdenes.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el diseño correspondiente definido en fragment_mi_orden.xml
        return inflater.inflate(R.layout.fragment_mi_orden, container, false);
    }
}
