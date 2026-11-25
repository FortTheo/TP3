package main.tp3.model;

import jakarta.validation.constraints.NotBlank;
import main.tp3.model.Pokemon;
import org.hibernate.annotations.processing.HQL;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends CrudRepository<main.tp3.model.Pokemon, Integer> {

    @Query("SELECT p FROM Pokemon p JOIN p.capacites c WHERE c.id = :idCapacite")
    List<main.tp3.model.Pokemon> findByCapacite(@Param("idCapacite") int idCapacite);

    Optional<main.tp3.model.Pokemon> findById(int id);


    List<main.tp3.model.Pokemon> findByNameLike(String name);

    @Modifying
    void deleteById(int id);

    List<main.tp3.model.Pokemon> findAllByOrderByIdAsc();

    List<main.tp3.model.Pokemon> findByCapacitesLibelleLike(String libelle);

    List<main.tp3.model.Pokemon> findByPoidsGreaterThan(int poidsGreaterThan);

    @Query("select c from Pokemon p join p.capacites c where p.id = :idPokemon")
    List<main.tp3.model.Capacite> findCapaciteByPokemon(@Param("idPokemon") int idPokemon);

    @Query("select count(p.capacites) from Pokemon p group by p.id having count(p)>=1")
    int countPokemonWithACapacites();

    @Query("select p from Pokemon p group by p.id having count(p.capacites) > 2")
    List<main.tp3.model.Pokemon> findPokemonWith2orMoreCapacite();

    @Query("select c from Pokemon p join p.capacites c group by c having count(p)=0")
    List<Capacite> findCapacitesWithoutCapacite();


}
