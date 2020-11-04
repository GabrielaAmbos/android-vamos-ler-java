package com.example.gabri.vamos_ler_30;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import consumer.ResponsavelConsumer;
import pojos.Responsavel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gabri on 30/10/2017.
 */

public class TelaCadastro extends AppCompatActivity {
    private Button btCadastrar;
    private EditText etcadNome;
    private EditText etcadEmail;
    private EditText etcadSenha;
    private ImageView ivVamos;
    private Responsavel responsavel;
    private ResponsavelConsumer responsavelConsumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        iniciaComponentes();

        this.btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                responsavel.setNomeResponsavel(etcadNome.getText().toString());
                responsavel.setEmail(etcadEmail.getText().toString());
                responsavel.setSenha(etcadSenha.getText().toString());


                responsavelConsumer.postCadastrarResposavel(responsavel).enqueue(new Callback<Responsavel>() {
                    @Override
                    public void onResponse(Call<Responsavel> call, Response<Responsavel> response) {
                        if(response.isSuccessful()) {
                            responsavel = response.body();
                            Intent itTelaLogado = new Intent(TelaCadastro.this, TelaMenu.class);
                            Bundle parametro = new Bundle();
                            parametro.putSerializable("responsavel", responsavel);
                            itTelaLogado.putExtras(parametro);
                            startActivity(itTelaLogado);
                            finish();
                        }

                    }

                    @Override
                    public void onFailure(Call<Responsavel> call, Throwable t) {
                        Toast.makeText(TelaCadastro.this, "Fala Comunicação", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    private void iniciaComponentes(){
        this.btCadastrar = (Button) findViewById(R.id.btCadastrar);
        this.etcadNome = (EditText) findViewById(R.id.etCadNome);
        this.etcadEmail = (EditText) findViewById(R.id.etCadEmail);
        this.etcadSenha = (EditText) findViewById(R.id.etCadSenha);
        this.ivVamos = (ImageView) findViewById(R.id.iv_vamos);
        this.responsavel = new Responsavel();
        this.responsavelConsumer = new ResponsavelConsumer();
    }
}
