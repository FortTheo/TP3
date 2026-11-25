package main.tp3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import main.tp3.model.Pokemon;

import java.util.List;

@Entity
public class Capacite {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Le libelle est obligatoire")
    private String libelle;

    public Capacite() {
    }

    public Capacite(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @ManyToMany(mappedBy = "capacites")
    @JsonIgnoreProperties("capacites")
    private List<Pokemon> pokemons;

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
}
