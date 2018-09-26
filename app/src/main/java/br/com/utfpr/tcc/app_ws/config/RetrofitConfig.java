package br.com.utfpr.tcc.app_ws.config;

import br.com.utfpr.tcc.app_ws.service.EventService;
import br.com.utfpr.tcc.app_ws.service.LoginService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by a1505602 on 19/09/18.
 */

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://cardapiando-api.azurewebsites.net/api/")
                .addConverterFactory(JacksonConverterFactory.create());

        retrofit = builder.client(httpClient.build()).build();
    }

    public LoginService getLoginService() {
        return this.retrofit.create(LoginService.class);
    }

    public EventService getEventService() {
        return this.retrofit.create(EventService.class);
    }
}
