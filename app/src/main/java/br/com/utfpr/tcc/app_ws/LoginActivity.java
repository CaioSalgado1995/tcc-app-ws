package br.com.utfpr.tcc.app_ws;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.utfpr.tcc.app_ws.config.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        final EditText userEmail = findViewById(R.id.user_email);
        final EditText userPassword = findViewById(R.id.user_password);
        final String email = userEmail.getText().toString();
        final String password = userPassword.getText().toString();
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<String> call = new RetrofitConfig().getLoginService().login(email, password);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String resposta = response.body();
                        Log.i("LoginService", "Login efetuado com " + resposta);
                        // connect with the main activity class with Intent
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("LoginService", "Erro ao tentar fazer login " + t.getMessage());
                    }
                });
            }
        });


    }

}
