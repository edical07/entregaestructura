package com.example.edical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * Fragmento que muestra las ofertas actuales dentro de la aplicación.
 */
public class OfertaFragment extends Fragment {

    /**
     * Constructor público vacío requerido.
     */
    public OfertaFragment() {
        // Constructor vacío obligatorio
    }

    /**
     * Crea la vista del fragmento inflando el diseño correspondiente.
     * 
     * @param inflater Utilizado para inflar el layout XML.
     * @param container El contenedor padre en el que se insertará la vista.
     * @param savedInstanceState Estado guardado previo (si existe).
     * @return La vista inflada para el fragmento de ofertas.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento: fragment_oferta.xml
        return inflater.inflate(R.layout.fragment_oferta, container, false);
    }
}
