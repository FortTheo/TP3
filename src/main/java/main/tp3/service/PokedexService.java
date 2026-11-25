package main.tp3.service;

import main.tp3.model.Capacite;
import main.tp3.model.CapaciteRepository;
import main.tp3.model.Pokemon;
import main.tp3.model.PokemonRepository;
import main.tp3.service.PokedexItrf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokedexService implements PokedexItrf {

    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    CapaciteRepository capaciteRepository;


    @Override
    public List<Pokemon> findAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @Override
    public List<Capacite> findAllCapacites() {
        return (List<Capacite>) capaciteRepository.findAll();
    }

    @Override
    public Pokemon findById(int id) {
        return pokemonRepository.findById(id).get();
    }

    @Override
    public void addCapacite(int idPokemon, int idCapacite) {
        Capacite capacite = capaciteRepository.findById(idCapacite).get();
        Pokemon pokemon = pokemonRepository.findById(idPokemon).get();
        pokemon.addCapacite(capacite);
        capaciteRepository.save(capacite);
        pokemonRepository.save(pokemon);
    }

    @Override
    public void deletePokemon(int idpokemon) {
        pokemonRepository.delete(pokemonRepository.findById(idpokemon).get());
    }

    @Override
    public List<Pokemon> findByCapacite(int idCapacite) {
        return pokemonRepository.findByCapacite(idCapacite);
    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    @Override
    public void saveCapacite(Capacite capacite) {
        capaciteRepository.save(capacite);
    }
}
