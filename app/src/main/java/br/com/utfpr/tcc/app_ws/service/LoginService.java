package br.com.utfpr.tcc.app_ws.service;

import br.com.utfpr.tcc.app_ws.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by a1505602 on 19/09/18.
 */

public interface LoginService {

    @POST("/Account/Autenthicate")
    Call<String> login(@Body User user);
}
