package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private Retrofit retrofit;

    public RetrofitConfig(){
       retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.4:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public HttpService getHttpService(){
       return retrofit.create(HttpService.class);
    }
}
