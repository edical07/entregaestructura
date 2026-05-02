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
import com.example.edical.modelo.CategoriaPrincipal;

import java.util.List;

public class CategoriaAdaptador extends RecyclerView.Adapter<CategoriaAdaptador.ViewHolder> {

    Context context;
    List<CategoriaPrincipal> categoriaList;

    public CategoriaAdaptador(Context context, List<CategoriaPrincipal> categoriaList) {
        this.context = context;
        this.categoriaList = categoriaList;
    }

    @NonNull
    @Override
    public CategoriaAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.principal_cat_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdaptador.ViewHolder holder, int position) {
        Glide.with(context).load(categoriaList.get(position).getImg_url()).into(holder.catImg);
        holder.nombre.setText(categoriaList.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView catImg;
        TextView nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catImg = itemView.findViewById(R.id.princ_cat_img);
            nombre = itemView.findViewById(R.id.cat_prin_nom);
        }
    }
}
