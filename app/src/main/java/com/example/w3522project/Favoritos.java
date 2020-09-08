package com.example.w3522project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.w3522project.adapter.MascotaAdapter;
import com.example.w3522project.fragment.IRecyclerViewFragmentView;
import com.example.w3522project.pojo.Mascota;
import com.example.w3522project.presenter.FavoritosFragmentPresenter;
import com.example.w3522project.presenter.IRecyclerViewFragmentPresenter;
import com.example.w3522project.presenter.HomeFragmentPresenter;

import java.util.ArrayList;
import java.util.Random;

public class Favoritos extends AppCompatActivity implements IRecyclerViewFragmentView {

    private RecyclerView listaMascotas;
    private MascotaAdapter adapter;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.favoritos_actionbar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        this.listaMascotas = (RecyclerView) findViewById(R.id.rv_favoritos_mascotas);

        this.presenter = new FavoritosFragmentPresenter(this, getBaseContext());
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        this.listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearMascotaAdapter(ArrayList<Mascota> mascotas) {
        this.adapter = new MascotaAdapter(mascotas, this);
        this.adapter.setEnableUI(false);
        return adapter;
    }

    @Override
    public void inicializarAdapterRV(MascotaAdapter mascotaAdapter) {
        this.listaMascotas.setAdapter(mascotaAdapter);
    }
}