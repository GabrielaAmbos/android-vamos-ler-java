package com.example.gabri.vamos_ler_30;

import android.app.Activity;
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

public class Atividade3 extends Activity {
    private ImageView im1;
    private RadioGroup RGescolha3;
    private RadioButton rbEscolha;
    private Button btProxima3;
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
        setContentView(R.layout.atividade_3);
        iniciaComponentes();

        this.RGescolha3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rbEscolha = (RadioButton) findViewById(checkedId);
            }
        });

        this.btProxima3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resposta.setResposta1(rbEscolha.getText().toString());
//                Intent itTela4 = new Intent(Atividade3.this, Atividade4.class);
//                Bundle resposta1 = new Bundle();
//                resposta1.putSerializable("resposta3", resposta);
//                itTela4.putExtras(resposta1);
//                startActivity(itTela4);
                finish();
            }
        });

        //"cadastrar" no servidor e no BD

    }

    public void iniciaComponentes(){
      //  this.im1 = (ImageView) findViewById(R.id.image_1);
        this.btProxima3 = (Button) findViewById(R.id.bt_proxima3);
        this.RGescolha3 = (RadioGroup) findViewById(R.id.rg_escolha3);
        this.tvPergunta1 = (TextView) findViewById(R.id.tv_pergunta1);
        this.cb1 = (RadioButton) findViewById(R.id.cb1_2);
        this.cb2 = (RadioButton) findViewById(R.id.cb2_2);
        this.cb3 = (RadioButton) findViewById(R.id.cb3_2);
        this.cb4 = (RadioButton) findViewById(R.id.cb4_2);
        this.resposta = new Resposta();
    }
}
