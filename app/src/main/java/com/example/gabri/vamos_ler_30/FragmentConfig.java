package com.example.gabri.vamos_ler_30;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import consumer.ResponsavelConsumer;
import pojos.Responsavel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_APPEND;

/**
 * Created by Gabri on 30/10/2017.
 */

public class FragmentConfig extends android.app.Fragment {
    private EditText etEditarN;
    private EditText etEtEditarE;
    private EditText etEtEditarS;
    private Button btAlterar;
    private TextView tvDeletar;
    private Responsavel responsavel;
    private ResponsavelConsumer responsavelConsumer;
    private Button BtSair;
    private TextView tvEditarAprendiz;
    private SharedPreferences spLogin;
    private SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conf, container, false);



        this.etEditarN = (EditText) view.findViewById(R.id.etAltNome);
        this.etEtEditarE = (EditText) view.findViewById(R.id.etAltEmail);
        this.etEtEditarS = (EditText) view.findViewById(R.id.etAltSenha);
        this.btAlterar = (Button) view.findViewById(R.id.btAlterar);
        this.tvDeletar = (TextView) view.findViewById(R.id.tvDeletar);
        this.responsavel = (Responsavel) getActivity().getIntent().getExtras().getSerializable("responsavel");
        this.responsavelConsumer = new ResponsavelConsumer();
        this.BtSair = (Button) view.findViewById(R.id.btSair);
        this.spLogin = getActivity().getApplicationContext().getSharedPreferences(TelaLogin.NOME_ARQUIVO,MODE_APPEND);
        this.editor = this.spLogin.edit();





        this.etEditarN.setText(this.responsavel.getNomeResponsavel());
        this.etEtEditarE.setText(this.responsavel.getEmail());
        this.etEtEditarS.setText(this.responsavel.getSenha());

       this.btAlterar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            responsavel.setNomeResponsavel(etEditarN.getText().toString());
            responsavel.setEmail(etEtEditarE.getText().toString());
            responsavel.setSenha(etEtEditarS.getText().toString());

            responsavelConsumer.putAtualizar(responsavel).enqueue(new Callback<Responsavel>() {
                @Override
                public void onResponse(Call<Responsavel> call, Response<Responsavel> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(getActivity(), "Dados atualizados!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Responsavel> call, Throwable t) {
                    Toast.makeText(getActivity(), "Dados atualizados!", Toast.LENGTH_LONG).show();
                }
            });

        }
    });

        this.tvDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                responsavelConsumer.deletePorId(responsavel.getIdResponsavel()).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getActivity(), "Conta apagada!", Toast.LENGTH_LONG).show();
                            Intent itTelaLogin = new Intent(getActivity(), TelaLogin.class);
                            Bundle parametros = new Bundle();
                            parametros.putSerializable("responsavel", responsavel);
                            itTelaLogin.putExtras(parametros);
                            startActivity(itTelaLogin);
                        }
//

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getActivity(), "Erro!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


                this.BtSair.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editor.clear();
                        editor.commit();
                        Intent itTelaLogin = new Intent(getActivity(), TelaLogin.class);
                        startActivity(itTelaLogin);
                        getActivity().finish();
                    }
                });


                return view;

            }

        }

