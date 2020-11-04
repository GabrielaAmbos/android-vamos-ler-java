package com.example.gabri.vamos_ler_30;

import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import pojos.Responsavel;

/**
 * Created by Gabri on 26/10/2017.
 */

public class TelaMenu extends AppCompatActivity {
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private SharedPreferences.Editor editor;
    private Responsavel responsavel;
    private TextView NomeResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);


        ActionBar actionBar=getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mdrawerLayout= (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle= new ActionBarDrawerToggle(this, mdrawerLayout, R.string.drawer_open, R.string.drawer_close);

        mDrawerToggle.syncState();
        mdrawerLayout.setDrawerListener(mDrawerToggle);
        NavigationView navigationView= (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_add:
                        selectItem(0);
                        break;
                    case R.id.action_config:
                        selectItem(1);
                        break;

                }
                return true;
            }

        });

    }
    private void selectItem(int position){
        android.app.Fragment fragment= null;
        String title= null;

        switch (position){
            case 0:
               fragment= new FragmentAddAprendiz();
                title="Aprendizes";
                break;
            case 1:
                fragment= new FragmentConfig();
                title="Editar Conta";
                break;
        }
        FragmentManager fm= getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, fragment). commit();
        setTitle(title);
        mdrawerLayout.closeDrawer(GravityCompat.START);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}