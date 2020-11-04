package com.example.gabri.vamos_ler_30;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gabri on 04/11/2017.
 */

public class FragmentAtividades extends Fragment {
    public static FragmentAtividades newInstance() {
        FragmentAtividades fragment = new FragmentAtividades();
        return fragment;
    }
    private CardView CVAtividade;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atividades, container, false);
        this.CVAtividade = (CardView) view.findViewById(R.id.card_view);

        CVAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itTelaAtividade = new Intent(getActivity(), Atividade1.class);
                startActivity(itTelaAtividade);
            }
        });

        return view;
    }
}
