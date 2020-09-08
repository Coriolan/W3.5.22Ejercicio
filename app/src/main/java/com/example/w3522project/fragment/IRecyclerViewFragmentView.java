package com.example.w3522project.fragment;

import com.example.w3522project.adapter.MascotaAdapter;
import com.example.w3522project.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearMascotaAdapter(ArrayList<Mascota> mascotas);

    public void inicializarAdapterRV(MascotaAdapter mascotaAdapter);
}
