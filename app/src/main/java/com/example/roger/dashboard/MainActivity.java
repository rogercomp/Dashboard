package com.example.roger.dashboard;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.example.roger.dashboard.dominio.Filme;
import com.example.roger.dashboard.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtFilme = findViewById(R.id.txtFilme);

        final ImageView img = findViewById(R.id.imgFilme);

        final Button btnCons =  findViewById(R.id.btnConsultar);

        btnCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Filme> call = new RetrofitConfig().getFilmeService().consulta( txtFilme.getText().toString(),"ab94a47a", "json");

               call.enqueue(new Callback<Filme>() {
                    @Override
                    public void onResponse(Call<Filme> call, Response<Filme> response) {

                            Filme f = response.body();

                            Glide.with(getBaseContext()).load(f.getPoster()).into(img);


                    }

                    @Override
                    public void onFailure(Call<Filme> call, Throwable t) {
                        Log.e("Serviço Filme", "Erro ao buscar o filme:" + t.getMessage());
                    }
                });
            }
        });

    }
}
