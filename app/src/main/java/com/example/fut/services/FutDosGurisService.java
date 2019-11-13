package com.example.fut.services;

import com.example.fut.model.Clube;
import com.example.fut.model.Jogador;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FutDosGurisService {

    public final String BASE_URL = "http://192.168.0.4:8080";

    @POST("cadastro-clube")
    Call<Clube> cadastraClube(@Body Clube clube);

    @POST("cadastro-jogador/")
    Call<Jogador> cadastraJogador(@Body Jogador jogador);

}
