package br.com.utfpr.tcc.app_ws;

import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.utfpr.tcc.app_ws.config.RetrofitConfig;
import br.com.utfpr.tcc.app_ws.model.User;
import br.com.utfpr.tcc.app_ws.service.LoginService;
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
        final EditText userEmail = findViewById(R.id.user_name);
        final EditText userPassword = findViewById(R.id.user_password);
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("LoginActivity", "Ativando click");

                final User user = new User();
                final String username = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                user.setUsername(username);
                user.setPassword(password);

                Log.i("LoginActivity", "Usuário ==  " + user.toString());

                LoginService client = new RetrofitConfig().getLoginService();
                Call<String> call = client.login(user);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        String resposta = response.body();
                        Log.i("LoginService", "Login efetuado com " + resposta);
                        Toast.makeText(LoginActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                        // connect with the main activity class with Intent
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("LoginService", "Erro ao tentar fazer login " + t.getMessage());
                        Toast.makeText(LoginActivity.this, "Erro", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

}
