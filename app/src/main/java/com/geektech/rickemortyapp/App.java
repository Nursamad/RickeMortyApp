package com.geektech.rickemortyapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.geektech.rickemortyapp.common.Resource;
import com.geektech.rickemortyapp.data.models.RickAndMortyResponse;
import com.geektech.rickemortyapp.data.remote.RetrofitClient;
import com.geektech.rickemortyapp.data.remote.RickAndMortyApi;
import com.geektech.rickemortyapp.data.repository.MainRepository;

import retrofit2.Retrofit;

public class App extends Application {
    public static RickAndMortyApi api;
    public static MainRepository repository;


    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient client = new RetrofitClient();
        api = client.provideApi();
    }
}
