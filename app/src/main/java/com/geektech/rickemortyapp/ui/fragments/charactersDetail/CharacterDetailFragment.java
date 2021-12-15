package com.geektech.rickemortyapp.ui.fragments.charactersDetail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.rickemortyapp.R;
import com.geektech.rickemortyapp.databinding.FragmentCharacterDetailBinding;

public class CharacterDetailFragment extends Fragment {
    private FragmentCharacterDetailBinding binding;

    public CharacterDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}