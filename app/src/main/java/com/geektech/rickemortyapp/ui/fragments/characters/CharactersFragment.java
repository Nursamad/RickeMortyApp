package com.geektech.rickemortyapp.ui.fragments.characters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.rickemortyapp.R;
import com.geektech.rickemortyapp.common.Resource;
import com.geektech.rickemortyapp.data.models.RickAndMortyResponse;
import com.geektech.rickemortyapp.databinding.FragmentCharactersBinding;

public class CharactersFragment extends Fragment {

    private FragmentCharactersBinding binding;
    private CharacterAdapter adapter;
    private CharacterViewModel viewModel;

    public CharactersFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
        adapter = new CharacterAdapter();
        viewModel.getCharacters();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharactersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.liveData.observe(getViewLifecycleOwner(), new Observer<Resource<RickAndMortyResponse<Character>>>() {
            @Override
            public void onChanged(Resource<RickAndMortyResponse<Character>> resource) {
                switch (resource.status) {
                    case SUCCESS: {
                        binding.recyclerViewCharacter.setVisibility(View.VISIBLE);
                        binding.progress.setVisibility(View.GONE);
                        adapter.setCharacters(resource.data.getResults());
                        break;
                    }
                    case ERROR: {
                        Log.e("TAG", "onChanged: ",resource.message );
                        break;
                    }
                    case LOADING: {
                        binding.recyclerViewCharacter.setVisibility(View.GONE);
                        binding.progress.setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }
        });
    }
}