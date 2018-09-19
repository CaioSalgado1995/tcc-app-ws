package br.com.utfpr.tcc.app_ws.service;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by a1505602 on 19/09/18.
 */

public interface LoginService {

    @POST("login")
    Call<String> login(String email, String password);
}
