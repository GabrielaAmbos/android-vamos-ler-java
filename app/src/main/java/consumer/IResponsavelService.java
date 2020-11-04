package consumer;

import java.util.List;

import pojos.Crianca;
import pojos.Responsavel;
import pojos.Resposta;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Gabri on 02/10/2017.
 */

public interface IResponsavelService {

    static final String URL_BASE = "http://192.168.137.1:8080/";

    @POST("responsavel/{email}/{senha}")
    Call<Responsavel> postAutentica(@Path("email") String email, @Path("senha") String senha);

    @POST("responsavel/")
    Call<Responsavel> postCadastrarResposavel(@Body Responsavel responsavel);

    @PUT("responsavel/")
    Call<Responsavel> putAtualizar(@Body Responsavel responsavel);

    @DELETE("responsavel/{idResponsavel}")
    Call<Void> deletePorId(@Path("idResponsavel")int idResponsavel);

    @POST("crianca/")
    Call<Crianca> cadastrarContaCrianca(@Body Crianca crianca);

    @GET("crianca/")
    Call<List<Crianca>> listaCriancas();

    @DELETE("crianca/{idCrianca}")
    Call<Void> deleteCriancaPorId(@Path("idCrianca") int idCrianca);

    @PUT("crianca/")
    Call<Crianca> updateCrianca(@Body Crianca crianca);

    @POST("resposta/")
    Call<Resposta> postCadastrarResposta(@Body Resposta resposta);
}
