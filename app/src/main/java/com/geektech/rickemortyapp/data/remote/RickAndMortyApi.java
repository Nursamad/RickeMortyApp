package com.geektech.rickemortyapp.data.remote;

import com.geektech.rickemortyapp.data.models.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RickAndMortyApi {

    @GET("character")
    Call<RickAndMortyResponse<Character>> getCharacters();
}
