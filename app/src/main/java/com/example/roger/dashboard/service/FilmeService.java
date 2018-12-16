package com.example.roger.dashboard.service;

import com.example.roger.dashboard.dominio.Filme;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmeService {

    @GET("./")
    Call<Filme> consulta(@Query("t") String filme, @Query("apikey") String apikey, @Query("r") String resposta );


}
