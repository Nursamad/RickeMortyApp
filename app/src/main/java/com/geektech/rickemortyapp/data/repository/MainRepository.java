package com.geektech.rickemortyapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.geektech.rickemortyapp.App;
import com.geektech.rickemortyapp.common.Resource;
import com.geektech.rickemortyapp.data.models.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    public MutableLiveData<Resource<RickAndMortyResponse<Character>>> getCharacters(){
        MutableLiveData<Resource<RickAndMortyResponse<Character>>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());

        App.api.getCharacters().enqueue(new Callback<RickAndMortyResponse<Character>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Character>> call, Response<RickAndMortyResponse<Character>> response) {
                if (response.isSuccessful()&& response.body() !=null){
                    liveData.setValue(Resource.success(response.body()));
                }else {
                    liveData.setValue(Resource.error(response.message(), null));
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Character>> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));
            }
        });
        return liveData;
    }
}
