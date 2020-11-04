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

public class FragmentHistoria extends Fragment {
    public static FragmentHistoria newInstance() {
        FragmentHistoria fragment = new FragmentHistoria();
        return fragment;
    }

    private CardView CVhistoria;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historia, container, false);

        this.CVhistoria = (CardView) view.findViewById(R.id.card_view);

        CVhistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itTelaHistoria = new Intent(getActivity(), Slide1.class);
                startActivity(itTelaHistoria);
            }
        });

        return view;
    }

}
