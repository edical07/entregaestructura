package com.example.edical.ui.categoria;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edical.R;
import com.example.edical.adaptadores.NavCategoriaAdaptador;
import com.example.edical.adaptadores.PopularAdaptador;
import com.example.edical.modelo.NavCategoriaModelo;
import com.example.edical.modelo.PopularModelo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CategoriaFragment extends Fragment {

    FirebaseFirestore db;
    RecyclerView recyclerView;
    List<NavCategoriaModelo> categoriaModeloList;
    NavCategoriaAdaptador navCategoriaAdaptador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.fragment_categoria,container,false);

        db = FirebaseFirestore.getInstance();
       recyclerView=root.findViewById(R.id.cat_rec);

        //Popular items
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        categoriaModeloList = new ArrayList<>();
        navCategoriaAdaptador = new NavCategoriaAdaptador(getActivity(),categoriaModeloList);
        recyclerView.setAdapter(navCategoriaAdaptador);

        db.collection("NavCategoria")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document:task.getResult()) {
                                NavCategoriaModelo navCategoriaModelo = document.toObject(NavCategoriaModelo.class);
                                categoriaModeloList.add(navCategoriaModelo);
                                navCategoriaAdaptador.notifyDataSetChanged();

                            }
                        }else {
                            Toast.makeText(getActivity(), "Error "+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

       return root;
    }

}