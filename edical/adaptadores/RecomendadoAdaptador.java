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
import com.example.edical.modelo.RecomendadoModelo;

import java.util.List;

/**
 * Adaptador para el RecyclerView que muestra la lista de productos recomendados.
 * Gestiona la creación de las vistas y la vinculación de los datos del modelo RecomendadoModelo.
 */
public class RecomendadoAdaptador extends RecyclerView.Adapter<RecomendadoAdaptador.ViewHolder> {

    // Contexto de la aplicación o actividad necesaria para inflar layouts y usar Glide
    Context context;
    // Lista de objetos que contienen la información de los productos recomendados
    List<RecomendadoModelo> list;

    /**
     * Constructor del adaptador.
     * 
     * @param context El contexto desde donde se utiliza el adaptador.
     * @param list    La lista de datos a mostrar.
     */
    public RecomendadoAdaptador(Context context, List<RecomendadoModelo> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * Crea y devuelve un nuevo ViewHolder inflado con el diseño de item recomendado.
     * 
     * @param parent   El ViewGroup en el que se añadirá la nueva vista.
     * @param viewType El tipo de la nueva vista (no se usa en este caso simple).
     * @return Una nueva instancia de ViewHolder.
     */
    @NonNull
    @Override
    public RecomendadoAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout recomendado_item.xml para cada elemento de la lista
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recomendado_item,parent,false));
    }

    /**
     * Vincula los datos de un elemento de la lista con los componentes visuales del ViewHolder.
     * 
     * @param holder   El ViewHolder que debe ser actualizado.
     * @param position La posición del elemento en la lista de datos.
     */
    @Override
    public void onBindViewHolder(@NonNull RecomendadoAdaptador.ViewHolder holder, int position) {
        // Carga la imagen del producto desde la URL usando la librería Glide
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.imageView);
        
        // Asigna el nombre, descripción y calificación al TextView correspondiente
        holder.nombre.setText(list.get(position).getNombre());
        holder.descripcion.setText(list.get(position).getDescripcion());
        holder.rating.setText(list.get(position).getRating());
    }

    /**
     * Devuelve el tamaño total de la lista de datos.
     * 
     * @return El número de elementos en la lista.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Clase interna que mantiene las referencias a las vistas de cada elemento de la lista.
     * Esto mejora el rendimiento al evitar llamadas repetidas a findViewById.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Componentes visuales definidos en el XML del item
        ImageView imageView;
        TextView nombre, descripcion, rating;

        /**
         * Constructor del ViewHolder que inicializa las referencias de las vistas.
         * 
         * @param itemView La vista raíz del elemento de la lista.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Vinculación de las variables con los IDs del layout recomendado_item.xml
            imageView = itemView.findViewById(R.id.rec_img);
            nombre= itemView.findViewById(R.id.rec_nombre);
            descripcion = itemView.findViewById(R.id.rec_dec);
            rating = itemView.findViewById(R.id.rec_rating);
        }
    }
}
