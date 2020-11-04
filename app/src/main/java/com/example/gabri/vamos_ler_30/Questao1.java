package com.example.gabri.vamos_ler_30;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gabri on 23/11/2017.
 */

public class Questao1 extends Activity {
    private Button btVai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagem_atividade);
        this.btVai = (Button) findViewById(R.id.bt_quest1);
        this.btVai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vai = new Intent(Questao1.this, Atividade1.class);
                startActivity(vai);
            }
        });
    }
}