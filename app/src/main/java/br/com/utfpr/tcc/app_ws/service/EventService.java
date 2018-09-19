package br.com.utfpr.tcc.app_ws.service;

import br.com.utfpr.tcc.app_ws.model.Event;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by a1505602 on 19/09/18.
 */

public interface EventService {

    @GET("event")
    Call<Event> getAllEvents();
}
