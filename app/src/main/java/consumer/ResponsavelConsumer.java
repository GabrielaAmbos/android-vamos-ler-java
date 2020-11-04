package consumer;

import java.util.ArrayList;
import java.util.List;

import pojos.Crianca;
import pojos.Responsavel;
import pojos.Resposta;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gabri on 02/10/2017.
 */

public class ResponsavelConsumer {

    List<Crianca> vetor = new ArrayList<Crianca>();


    private Retrofit retrofit;
    private IResponsavelService responsavelService;

    public ResponsavelConsumer() {
        this.retrofit = new Retrofit.Builder().baseUrl(IResponsavelService.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();
        this.responsavelService = retrofit.create(IResponsavelService.class);
    }

    public Call<Responsavel> postAutentica(String email, String senha) {

        return this.responsavelService.postAutentica(email, senha);
    }

    public Call<Responsavel> postCadastrarResposavel(Responsavel responsavel){
        return this.responsavelService.postCadastrarResposavel(responsavel);
    }

    public Call<Responsavel> putAtualizar(Responsavel responsavel) {
        return this.responsavelService.putAtualizar(responsavel);
    }

    public Call<Void> deletePorId(int idResponsavel) {return this.responsavelService.deletePorId(idResponsavel);}


    public Call<Crianca> cadastrarContaCrianca(Crianca crianca){
        return this.responsavelService.cadastrarContaCrianca(crianca);
    }

    public Call<List<Crianca>> listaCriancas() {
        return this.responsavelService.listaCriancas();
    }

    public Call<Void> deleteCriancaPorId(int idCrianca){
        return this.responsavelService.deleteCriancaPorId(idCrianca);
    }

    public Call<Crianca> updateCrianca(Crianca crianca){
        return this.responsavelService.updateCrianca(crianca);
    }

    public Call<Resposta> postCadastrarResposta(Resposta resposta){
        return this.responsavelService.postCadastrarResposta(resposta);
    }
}
