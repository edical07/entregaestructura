package com.example.edical.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edical.R;
import com.example.edical.adaptadores.CategoriaAdaptador;
import com.example.edical.adaptadores.PopularAdaptador;
import com.example.edical.adaptadores.RecomendadoAdaptador;
import com.example.edical.modelo.CategoriaPrincipal;
import com.example.edical.modelo.PopularModelo;
import com.example.edical.modelo.RecomendadoModelo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    ScrollView scrollView;
    ProgressBar progressBar;
    RecyclerView popularPopRec,principalCatRec,recomendadoRec;
    FirebaseFirestore db;

    //Items populares
    List<PopularModelo> popularModeloList;
    PopularAdaptador popularAdaptador;

    //Categorías Principal
    List<CategoriaPrincipal> categoriaPrincipalList;
    CategoriaAdaptador categoriaAdaptador;

    //Recomendado Principal
    List<RecomendadoModelo> recomendadoModeloList;
    RecomendadoAdaptador recomendadoAdaptador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);
        db = FirebaseFirestore.getInstance();
        popularPopRec=root.findViewById(R.id.pop_rec);
        principalCatRec=root.findViewById(R.id.explora_rec);
        recomendadoRec=root.findViewById(R.id.recomendados_rec);
        scrollView=root.findViewById(R.id.scrollhome);
        progressBar=root.findViewById(R.id.progresshome);

        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        //Popular items
        popularPopRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        popularModeloList = new ArrayList<>();
        popularAdaptador = new PopularAdaptador(getActivity(),popularModeloList);
        popularPopRec.setAdapter(popularAdaptador);

        db.collection("ProductosPopulares")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document:task.getResult()) {
                                PopularModelo popularModelo = document.toObject(PopularModelo.class);
                                popularModeloList.add(popularModelo);
                                popularAdaptador.notifyDataSetChanged();

                                progressBar.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);
                            }
                        }else {
                            Toast.makeText(getActivity(), "Error "+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //Categoria Principal items
        principalCatRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoriaPrincipalList = new ArrayList<>();
        categoriaAdaptador = new CategoriaAdaptador(getActivity(),categoriaPrincipalList);
        principalCatRec.setAdapter(categoriaAdaptador);

        db.collection("CategoriasPrincipal")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document:task.getResult()) {
                                CategoriaPrincipal categoriaPrincipal = document.toObject(CategoriaPrincipal.class);
                                categoriaPrincipalList.add(categoriaPrincipal);
                                categoriaAdaptador.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getActivity(), "Error "+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //Recomendado Principal items
        recomendadoRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recomendadoModeloList = new ArrayList<>();
        recomendadoAdaptador = new RecomendadoAdaptador(getActivity(),recomendadoModeloList);
        recomendadoRec.setAdapter(recomendadoAdaptador);

        db.collection("Recomendados")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document:task.getResult()) {
                                RecomendadoModelo recomendadoModelo = document.toObject(RecomendadoModelo.class);
                                recomendadoModeloList.add(recomendadoModelo);
                                recomendadoAdaptador.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getActivity(), "Error "+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        return root;
    }

}