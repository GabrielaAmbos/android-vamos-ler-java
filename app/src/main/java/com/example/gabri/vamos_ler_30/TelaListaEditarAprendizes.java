package com.example.gabri.vamos_ler_30;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import consumer.ResponsavelConsumer;
import pojos.Crianca;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gabri on 17/11/2017.
 */

public class TelaListaEditarAprendizes extends ListActivity {
    private List<Crianca> listaCrianca;
    private ResponsavelConsumer responsavelConsumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.responsavelConsumer = new ResponsavelConsumer();
        responsavelConsumer.listaCriancas().enqueue(new Callback<List<Crianca>>() {
            @Override
            public void onResponse(Call<List<Crianca>> call, Response<List<Crianca>> response) {

                if (response.isSuccessful()) {
                    listaCrianca = response.body();
                    ArrayAdapter<Crianca> adapter = new ArrayAdapter<Crianca>(TelaListaEditarAprendizes.this, android.R.layout.simple_list_item_1, listaCrianca);
                    setListAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Crianca>> call, Throwable t) {

            }
        });


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent itTelaEditarA = new Intent(this, TelaEditarAprendizes.class);
        Bundle parametro = new Bundle();
        parametro.putSerializable("crianca", listaCrianca.get(position));
        itTelaEditarA.putExtras(parametro);
        itTelaEditarA.putExtra("acao", "editar");
        startActivity(itTelaEditarA);
    }

}
