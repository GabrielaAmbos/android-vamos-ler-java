package com.example.gabri.vamos_ler_30;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Gabri on 24/10/2017.
 */

public class SplashScreen extends AppCompatActivity {
    private ImageView SpS;
    // Timer da splash screen
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, TelaLogin.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void iniciaComponentes(){
        this.SpS = (ImageView) findViewById(R.id.ss);
    }

}