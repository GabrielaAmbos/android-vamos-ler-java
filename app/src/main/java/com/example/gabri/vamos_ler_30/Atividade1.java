package com.example.gabri.vamos_ler_30;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import consumer.ResponsavelConsumer;
import pojos.Resposta;

/**
 * Created by Gabri on 20/11/2017.
 */

public class Atividade1 extends Activity {
    private ImageView im1;
    private RadioGroup RGescolha1;
    private RadioButton rbEscolha;
    private Button btProxima1;
    private TextView tvPergunta1;
    private Resposta resposta;
    private RadioButton cb1;
    private RadioButton cb2;
    private RadioButton cb3;
    private RadioButton cb4;
    private ResponsavelConsumer responsavelConsumer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_1);
        iniciaComponentes();

//        this.RGescolha1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                rbEscolha = (RadioButton) findViewById(checkedId);
//            }
//        });

//        this.tvPergunta1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              //  resposta.setResposta1(rbEscolha.getText().toString());
//                Intent itTela2 = new Intent(Atividade1.this, Questao1.class);
////                Bundle resposta1 = new Bundle();
////                resposta1.putSerializable("resposta1", resposta);
////                itTela2.putExtras(resposta1);
//               // itTelaMenu.putExtra("acao", "editar");
//                startActivity(itTela2);
//                finish();
//
//            }
//        });

        this.btProxima1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itproxima = new Intent(Atividade1.this, Atividade2.class);
                startActivity(itproxima);
                finish();
            }
        });

        //"cadastrar" no servidor e no BD

    }

    public void iniciaComponentes() {
        this.im1 = (ImageView) findViewById(R.id.imageView7);
        this.btProxima1 = (Button) findViewById(R.id.bt_proxima1);
        this.RGescolha1 = (RadioGroup) findViewById(R.id.rg_escolha1);
        this.tvPergunta1 = (TextView) findViewById(R.id.tv_pergunta1);
        this.cb1 = (RadioButton) findViewById(R.id.cb1);
        this.cb2 = (RadioButton) findViewById(R.id.cb2);
        this.cb3 = (RadioButton) findViewById(R.id.cb3);
        this.cb4 = (RadioButton) findViewById(R.id.cb4);
        this.resposta = new Resposta();
        this.responsavelConsumer =  new ResponsavelConsumer();
    }
}