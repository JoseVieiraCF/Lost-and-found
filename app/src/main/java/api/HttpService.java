package api;

import java.util.List;

import modelo.Item;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HttpService {

    @GET("/itens/cod/{codigo}")
    Call<Item> buscarPorId(@Path("codigo") Long codigo);

    @GET("/itens/{item}")
    Call<List<Item>> buscarTodoItem(@Path("item") String item);

    @GET("/itens/status/true")
    Call<List<Item>> buscarItemDevolvido();

    @GET("/itens/status/{nome}/{status}")
    Call<List<Item>> buscarItemNaoDelvolvido(@Path("nome") String nome, @Path("status") String status);

    @GET("/itens/{nome}/{vistoPorUltimo}")
    Call<List<Item>> buscarVistoPorUltimo(@Path("nome") String nome, @Path("vistoPorUltimo") String vistoPorUltimo);
    //Call<List<Item>> buscarVistoPorUltimo(@Query("nome") String nome, @Query("vistoPorUltimo") String vistoPorUltimo);
}
