package com.example.edical.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.edical.R;
import com.example.edical.modelo.TodosModelo;

import java.util.List;

/**
 * Adaptador para el RecyclerView que maneja la visualización de la lista de productos.
 */
public class TodosAdaptador extends RecyclerView.Adapter<TodosAdaptador.ViewHolder> {

    // Contexto de la aplicación o actividad
    Context context;
    // Lista de datos que se mostrarán en el RecyclerView
    List<TodosModelo> list;

    // Nota: Es importante inicializar estas variables mediante un constructor
    // para evitar errores de puntero nulo al ejecutar la aplicación.

    /**
     * Este método se encarga de crear y "inflar" la vista de cada fila (item) de la lista.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Se infla el diseño definido en 'todos_item.xml'
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.todos_item,parent,false));
    }

    /**
     * Este método vincula los datos de un objeto específico de la lista con los elementos visuales del ViewHolder.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // Se usa Glide para cargar la imagen desde una URL en el ImageView
        Glide.with(context).load(list.get(position).getImg_url()).into(viewHolder.imageView);
        
        // Se asignan los textos correspondientes desde el modelo (nombre, descripción, rating y precio)
        viewHolder.nombre.setText(list.get(position).getNombre());
        viewHolder.descripcion.setText(list.get(position).getDescripcion());
        viewHolder.rating.setText(list.get(position).getRating());
        
        // Se añade el sufijo "/Kg" al precio para mostrarlo formateado
        viewHolder.precio.setText(list.get(position).getPrecio()+" /Kg");
    }

    /**
     * Indica al RecyclerView cuántos elementos hay en total en la lista.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Clase interna que sirve de contenedor para las vistas de cada elemento de la lista.
     * Ayuda a que el RecyclerView sea eficiente al reciclar las vistas.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Componentes visuales de cada ítem
        ImageView imageView;
        TextView nombre,descripcion,precio,rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            // Se asocian las variables con los componentes definidos en el archivo XML (todos_item.xml)
            imageView = itemView.findViewById(R.id.Todos_img);
            nombre = itemView.findViewById(R.id.Todos_nombre);
            descripcion = itemView.findViewById(R.id.Todos_descripcion);
            precio = itemView.findViewById(R.id.Todos_precio);
            rating = itemView.findViewById(R.id.Todos_rating);
        }
    }
}
