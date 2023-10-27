package com.danieer.galvez.pokeapp.presentation.mappers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danieer.galvez.pokeapp.data.entities.Pokemon
import com.danieer.galvez.pokeapp.databinding.PokemonItemViewBinding

class PokemonAdapter(
    private val pokemonList: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    inner class PokemonViewHolder(val binding: PokemonItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding =
            PokemonItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        with(holder) {
            val pokemon = pokemonList[position]
            binding.apply {
                textViewPokemonName.text = pokemon.name
            }
            holder.itemView.setOnClickListener { Unit }

        }
    }
}