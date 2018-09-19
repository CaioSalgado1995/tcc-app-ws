package br.com.utfpr.tcc.app_ws.config;

import br.com.utfpr.tcc.app_ws.service.EventService;
import br.com.utfpr.tcc.app_ws.service.LoginService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by a1505602 on 19/09/18.
 */

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public LoginService getLoginService() {
        return this.retrofit.create(LoginService.class);
    }

    public EventService getEventService() {
        return this.retrofit.create(EventService.class);
    }
}
