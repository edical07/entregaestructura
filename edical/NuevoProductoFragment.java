package com.example.edical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * Fragmento encargado de la interfaz para agregar un nuevo producto.
 * Permite al usuario (posiblemente administrador) introducir datos de un nuevo producto
 * para ser guardado en la base de datos.
 */
public class NuevoProductoFragment extends Fragment {

    /**
     * Constructor público vacío requerido por el sistema de Android para instanciar
     * el fragmento (por ejemplo, al recrearlo tras un cambio de orientación).
     */
    public NuevoProductoFragment() {
        // Constructor vacío obligatorio
    }

    /**
     * Se llama para que el fragmento instancie su interfaz de usuario.
     * 
     * @param inflater El objeto LayoutInflater que se puede utilizar para inflar vistas en el fragmento.
     * @param container Si no es nulo, es la vista principal a la que se debe adjuntar la interfaz del fragmento.
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado guardado anterior.
     * @return Retorna la vista (View) para la interfaz de usuario del fragmento.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el diseño XML específico para este fragmento: fragment_nuevo_producto.xml
        return inflater.inflate(R.layout.fragment_nuevo_producto, container, false);
    }
}
