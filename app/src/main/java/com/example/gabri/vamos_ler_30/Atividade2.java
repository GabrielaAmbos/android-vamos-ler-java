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

public class Atividade2 extends Activity {

    private ImageView im1;
    private RadioGroup RGescolha2;
    private RadioButton rbEscolha;
    private Button btProxima2;
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
        setContentView(R.layout.atividade_2);

       // this.im1 = (ImageView) findViewById(R.id.image_1);
        this.btProxima2 = (Button) findViewById(R.id.bt_proxima2);
        this.RGescolha2 = (RadioGroup) findViewById(R.id.rg_escolha1);
        this.tvPergunta1 = (TextView) findViewById(R.id.tv_pergunta1);
        this.cb1 = (RadioButton) findViewById(R.id.cb1_1);
        this.cb2 = (RadioButton) findViewById(R.id.cb_2_1);
        this.cb3 = (RadioButton) findViewById(R.id.cb_3_1);
        this.cb4 = (RadioButton) findViewById(R.id.cb_4_1);
        this.resposta = new Resposta();

//        this.RGescolha2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                rbEscolha = (RadioButton) findViewById(checkedId);
//            }
//        });

        this.btProxima2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resposta.setResposta1(rbEscolha.getText().toString());

                        Intent itTela3 = new Intent(Atividade2.this, Atividade3.class);
//                        Bundle resposta1 = new Bundle();
//                        resposta1.putSerializable("resposta2", resposta);
//                        itTela3.putExtras(resposta1);
                        // itTelaMenu.putExtra("acao", "editar");
                        startActivity(itTela3);
                finish();

                    }
                });

                //"cadastrar" no servidor e no BD

            }
        }





