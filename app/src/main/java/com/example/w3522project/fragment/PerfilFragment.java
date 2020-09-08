package com.example.w3522project.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.w3522project.R;
import com.example.w3522project.adapter.FotoAdapter;
import com.example.w3522project.pojo.Foto;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Foto> fotos;
    private RecyclerView listaFotos;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        this.listaFotos = (RecyclerView) view.findViewById(R.id.rv_fotos);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        this.listaFotos.setLayoutManager(glm);

        /*LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        this.listaFotos.setLayoutManager(llm);*/

        inicializarListaFotos();
        inicializarAdapter();

        return view;
    }

    private void inicializarAdapter() {
        FotoAdapter adapter = new FotoAdapter(this.fotos, getActivity());
        listaFotos.setAdapter(adapter);
    }

    private void inicializarListaFotos() {
        this.fotos = new ArrayList<Foto>();

        Random rand = new Random();

        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));
        this.fotos.add(new Foto(rand.nextInt(11), R.drawable.pet2));

    }
}