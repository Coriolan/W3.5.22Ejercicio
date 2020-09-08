package com.example.w3522project.presenter;

import android.content.Context;

import com.example.w3522project.db.MascotasBuilder;
import com.example.w3522project.fragment.IRecyclerViewFragmentView;
import com.example.w3522project.pojo.Mascota;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private MascotasBuilder mascotasBuilder;
    private ArrayList<Mascota> mascotas;

    public HomeFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        this.obtenerMascotasDB();
    }

    @Override
    public void obtenerMascotasDB() {
        this.mascotasBuilder = new MascotasBuilder(this.context);
        this.mascotas = mascotasBuilder.obtenerDatos();
        mostrarMascotaRV();

    }

    @Override
    public void mostrarMascotaRV() {
        iRecyclerViewFragmentView.inicializarAdapterRV(iRecyclerViewFragmentView.crearMascotaAdapter(this.mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

}
