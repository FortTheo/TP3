package main.tp3.service;

import main.tp3.model.*;

import java.util.*;

public interface PokedexItrf {
    List<Pokemon> findAll();

    Pokemon findById(int id);

    void addCapacite(int idPokemon, int idCapacite);

    void deletePokemon(int idPokemon);

    void savePokemon(Pokemon pokemon);

    void saveCapacite(Capacite capacite);

    List<Capacite> findAllCapacites();

    List<Pokemon> findByCapacite(int idcapacite);
}
