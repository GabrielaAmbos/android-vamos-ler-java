package com.example.gabri.vamos_ler_30;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pojos.Resposta;

/**
 * Created by Gabri on 20/11/2017.
 */

public class Atividade4 extends Activity {

    private TextView pontos;
    private Resposta resposta;
    private Button btProxima4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_4);
        iniciaComponentes();
        this.btProxima4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void iniciaComponentes(){
        this.pontos = (TextView) findViewById(R.id.tv_ponto);
        this.resposta = (Resposta) getIntent().getExtras().getSerializable("resposta");
        this.btProxima4 = (Button) findViewById(R.id.bt_continua);
    }
}
