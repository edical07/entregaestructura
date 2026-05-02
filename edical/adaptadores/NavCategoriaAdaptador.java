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
import com.example.edical.modelo.NavCategoriaModelo;

import java.util.List;

public class NavCategoriaAdaptador extends RecyclerView.Adapter<NavCategoriaAdaptador.ViewHolder> {

    Context context;
    List<NavCategoriaModelo> list;

    public NavCategoriaAdaptador(Context context, List<NavCategoriaModelo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NavCategoriaAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_cat_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImg_url()).into(holder.imageView);
        holder.nombre.setText(list.get(position).getNombre());
        holder.descripcion.setText(list.get(position).getDescripcion());
        holder.descuento.setText(list.get(position).getDescuento());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nombre,descripcion,descuento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.princ_cat_img);//cat_nav_img
            nombre=itemView.findViewById(R.id.nav_categoria);//nav_cat_nombre
            descripcion=itemView.findViewById(R.id.nav_nuevoProducto);//nav_cat_descripcion
            descuento=itemView.findViewById(R.id.nav_oferta);//nav_cat_descuento
        }
    }
}
