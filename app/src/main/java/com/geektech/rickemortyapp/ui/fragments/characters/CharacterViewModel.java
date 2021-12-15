package com.geektech.rickemortyapp.ui.fragments.characters;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.rickemortyapp.App;
import com.geektech.rickemortyapp.common.Resource;
import com.geektech.rickemortyapp.data.models.RickAndMortyResponse;

public class CharacterViewModel extends ViewModel {

    public LiveData<Resource<RickAndMortyResponse<Character>>> liveData;

    public CharacterViewModel() {
    }

    public void getCharacters(){
      liveData = App.repository.getCharacters();
    }
}
