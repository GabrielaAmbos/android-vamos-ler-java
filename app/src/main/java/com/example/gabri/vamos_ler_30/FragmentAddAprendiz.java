package com.example.gabri.vamos_ler_30;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import consumer.ResponsavelConsumer;
import pojos.Crianca;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gabri on 30/10/2017.
 */

public class FragmentAddAprendiz extends Fragment {
    private EditText EtNomeCrianca;
    private TextView Eba;
    private Button btAdicionarCrianca;
    private Crianca crianca;
    private ResponsavelConsumer responsavelConsumer;
    private Button btListar;
    private TextView tvEditarAprendiz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_aprendiz, container, false);

        this.Eba = (TextView) view.findViewById(R.id.tvEba);
        this.EtNomeCrianca = (EditText) view.findViewById(R.id.et_nome_crianca);
        this.btAdicionarCrianca = (Button) view.findViewById(R.id.bt_adicionar_crianca);
        this.crianca = new Crianca();
        this.responsavelConsumer = new ResponsavelConsumer();
        this.btListar = (Button) view.findViewById(R.id.btListar);
        this.tvEditarAprendiz = (TextView) view.findViewById(R.id.tv_apagarAprendiz);

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itTelaListar = new Intent(getActivity(), TelaListarAprendizes.class);
                startActivity(itTelaListar);
            }
        });


        this.tvEditarAprendiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaEditar = new Intent(getActivity(), TelaListaEditarAprendizes.class);
                startActivity(itTelaEditar);
                Bundle parametros = new Bundle();
                parametros.putSerializable("abrir", crianca);
                itTelaEditar.putExtras(parametros);
                startActivity(itTelaEditar);
            }
        });





        this.btAdicionarCrianca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crianca.setNomeCrianca(EtNomeCrianca.getText().toString());

        responsavelConsumer.cadastrarContaCrianca(crianca).enqueue(new Callback<Crianca>() {
            @Override
            public void onResponse(Call<Crianca> call, Response<Crianca> response) {
                if (response.isSuccessful()) {
                    crianca = response.body();
                }
            }

            @Override
            public void onFailure(Call<Crianca> call, Throwable t) {
                Toast.makeText(getActivity(), "Aprendiz adicionado!", Toast.LENGTH_SHORT).show();
            }
        });
            }
        });


     return view;
}

}

