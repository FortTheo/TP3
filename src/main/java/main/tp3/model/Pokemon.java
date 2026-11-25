package main.tp3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.*;
import main.tp3.model.Capacite;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue()
    private int id;

    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @NotBlank(message = "Le poids est obligatoire")
    private String poids;

    public Pokemon() {
    }

    public Pokemon(String name, String poids) {
        this.name = name;
        this.poids = poids;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    @ManyToMany

    private List<Capacite> capacites = new ArrayList<>();

    public List<Capacite> getCapacites() {
        return capacites;
    }

    public void addCapacite(Capacite capacite) {
        this.capacites.add(capacite);
    }


}
