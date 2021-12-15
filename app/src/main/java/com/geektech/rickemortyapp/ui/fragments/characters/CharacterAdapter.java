package com.geektech.rickemortyapp.ui.fragments.characters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geektech.rickemortyapp.data.models.Character;
import com.geektech.rickemortyapp.databinding.ItemCharacterBinding;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<Character> characters = new ArrayList<>();

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCharacterBinding binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(characters.get(position));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCharacterBinding binding;

        public ViewHolder(@NonNull ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Character character) {
            binding.nameTv.setText(character.getName());
            binding.statusTv.setText(character.getStatus());
            Glide.with(binding.getRoot()).load(character.getImage()).circleCrop().into(binding.characterIv);
        }
    }
}
