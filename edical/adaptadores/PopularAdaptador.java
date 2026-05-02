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
import com.example.edical.modelo.PopularModelo;

import java.util.List;

public class PopularAdaptador extends RecyclerView.Adapter<PopularAdaptador.ViewHolder> {

    private Context context;
    private List<PopularModelo> popularModeloList;

    public PopularAdaptador(Context context, List<PopularModelo> popularModeloList) {
        this.context = context;
        this.popularModeloList = popularModeloList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(popularModeloList.get(position).getImg_url()).into(holder.popImg);
        holder.nombre.setText(popularModeloList.get(position).getNombre());
        holder.rating.setText(popularModeloList.get(position).getRating());
        holder.descripcion.setText(popularModeloList.get(position).getDescripcion());
        holder.descuento.setText(popularModeloList.get(position).getDescuento());
    }

    @Override
    public int getItemCount() {

        return popularModeloList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView popImg;
        TextView nombre, descripcion, rating, descuento;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popImg=itemView.findViewById(R.id.pop_img);
            nombre=itemView.findViewById(R.id.pop_nombre);
            descripcion=itemView.findViewById(R.id.pop_des);
            descuento=itemView.findViewById(R.id.pop_descuento);
            rating=itemView.findViewById(R.id.pop_rating);
        }
    }
}
