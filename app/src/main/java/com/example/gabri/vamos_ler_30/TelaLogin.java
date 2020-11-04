package com.example.gabri.vamos_ler_30;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import consumer.ResponsavelConsumer;
import pojos.Responsavel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gabri on 30/10/2017.
 */

public class TelaLogin  extends AppCompatActivity {
    private Button btLogar;
    private EditText etEmail;
    private EditText etSenha;
    private TextView tvRegistro;
    private ImageView imVamos;
    private SharedPreferences spLogin;
    private SharedPreferences.Editor editor;
    private Responsavel responsavel;
    private ResponsavelConsumer responsavelConsumer;
    public static final String NOME_ARQUIVO = "arquivo_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        iniciaComponentes();

        if (this.verificaJaLogou()) {
            chamaTelaLogado();
        }

        this.btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("debug","entrou");
                responsavel.setEmail(etEmail.getText().toString());
                    responsavel.setSenha(etSenha.getText().toString());
                    autenticaWS(responsavel.getEmail(),responsavel.getSenha());
            }
        });

        this.tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaCadastro = new Intent(TelaLogin.this, TelaCadastro.class);
                startActivity(itTelaCadastro);
                finish();
            }
        });


    }

    private boolean verificaJaLogou() {
        boolean logou = false;
        String login = this.spLogin.getString("login", null);
        if(login!=null) {
            this.responsavel.setEmail(login);
            logou = true;
        }
        return logou;
    }
    private void chamaTelaLogado() {
        Intent itTelaLogado = new Intent(TelaLogin.this, TelaMenu.class);
        Bundle parametros = new Bundle();
        parametros.putSerializable("responsavel", responsavel);
        itTelaLogado.putExtras(parametros);
        startActivity(itTelaLogado);
        finish();
    }

    private Responsavel autenticaWS(String email, String senha) {
        Log.i("debug","entrou AutenticaWS");

        this.responsavelConsumer.postAutentica(email, senha).enqueue(new Callback<Responsavel>() {
            @Override
            public void onResponse(Call<Responsavel> call, Response<Responsavel> response) {
                Log.i("debug","entrou OnResponse");
                responsavel = response.body();
                if(response.isSuccessful() && responsavel != null) {
                    editor.putString("email", responsavel.getEmail());
                   editor.commit();
                   chamaTelaLogado();
               }
                else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(TelaLogin.this, jObjError.getString("errorMessage"), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Override
            public void onFailure(Call<Responsavel> call, Throwable t) {
                Log.i("debug","erro");
                t.printStackTrace();

            }
        });


        return responsavel;
    }

    private void iniciaComponentes(){
        this.btLogar = (Button) findViewById(R.id.btLogar);
        this.etEmail = (EditText) findViewById(R.id.EtEmailResp);
        this.etSenha = (EditText) findViewById(R.id.etSenhaResp);
        this.tvRegistro = (TextView) findViewById(R.id.tv_registro);
        this.imVamos = (ImageView) findViewById(R.id.iv_vamos);
        this.spLogin = getApplicationContext().getSharedPreferences(NOME_ARQUIVO,MODE_APPEND);
        this.editor = this.spLogin.edit();
        this.responsavelConsumer = new ResponsavelConsumer();
        this.responsavel = new Responsavel();

    }

}
