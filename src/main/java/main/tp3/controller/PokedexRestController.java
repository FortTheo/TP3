package main.tp3.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import main.tp3.service.*;
import main.tp3.model.*;

import java.util.List;

@RestController
@RequestMapping("/pokedex")
public class PokedexRestController {

    @Autowired
    PokedexItrf pokedexService;

    @GetMapping("/entree")
    public ResponseEntity<List<Pokemon>> getAll() {
        List<Pokemon> pokemons = pokedexService.findAll();
        if (pokemons.isEmpty())
            return ResponseEntity.noContent().build(); // code 204
        else return ResponseEntity.ok(pokemons); // code 200
    }


}
