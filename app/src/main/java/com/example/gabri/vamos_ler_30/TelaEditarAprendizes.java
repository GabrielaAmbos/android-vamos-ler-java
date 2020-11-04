package com.example.gabri.vamos_ler_30;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
 * Created by Gabri on 17/11/2017.
 */

public class TelaEditarAprendizes extends Activity {
    private TextView tvOpa;
    private TextView tvDeletarAprendiz;
    private EditText etNovoAprendiz;
    private Button btAlterarCrianca;
    private Crianca crianca;
    private ResponsavelConsumer responsavelConsumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_editar_aprendiz);

        this.tvOpa = (TextView) findViewById(R.id.tvEba);
        this.tvDeletarAprendiz = (TextView) findViewById(R.id.tv_deletarAprendiz);
        this.etNovoAprendiz = (EditText) findViewById(R.id.et_nome_crianca_N);
        this.btAlterarCrianca = (Button) findViewById(R.id.bt_alterar_Crianca);
        this.responsavelConsumer = new ResponsavelConsumer();
        this.crianca = (Crianca) getIntent().getExtras().getSerializable("crianca");
        iniciaComponentes();

        this.etNovoAprendiz.setText(this.crianca.getNomeCrianca());

        this.btAlterarCrianca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crianca.setNomeCrianca(etNovoAprendiz.getText().toString());

                responsavelConsumer.updateCrianca(crianca).enqueue(new Callback<Crianca>() {
                    @Override
                    public void onResponse(Call<Crianca> call, Response<Crianca> response) {
                        if(response.isSuccessful()){
                            crianca = response.body();
                            Toast.makeText(TelaEditarAprendizes.this, "Sucesso ao editar", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Crianca> call, Throwable t) {

                    }
                });
            }
        });

        this.tvDeletarAprendiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("debug","deleta");
                responsavelConsumer.deleteCriancaPorId(crianca.getIdCrianca()).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Log.i("debug", "deletei");
                            Toast.makeText(TelaEditarAprendizes.this, "Dados atualizados!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(TelaEditarAprendizes.this, "Erro!", Toast.LENGTH_LONG).show();
                        Log.i("debug","erro");
                        t.printStackTrace();
                    }
                });
            }
        });


    }
    private void iniciaComponentes(){

    }
}
