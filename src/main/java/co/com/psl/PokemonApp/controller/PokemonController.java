package co.com.psl.PokemonApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.psl.PokemonApp.dto.Pokemon;
import co.com.psl.PokemonApp.dto.Type;
import co.com.psl.PokemonApp.repository.PokemonRepository;
import co.com.psl.PokemonApp.repository.TypeRepository;

@RestController
public class PokemonController {
	@Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private TypeRepository typeRepository;
    
    @RequestMapping(value = "/pokemon", method = RequestMethod.GET)
	public @ResponseBody List<Pokemon> allPokemon(@RequestParam(value="name", required = false) String name) {
		if (name == null) {
			return pokemonRepository.findAll();
		} else {
			return pokemonRepository.findByNameContaining(name);
		}
	}
    
    @RequestMapping(value = "/pokemon/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Pokemon> PokemonById(@PathVariable("id") long id) {
		return (List<Pokemon>) pokemonRepository.findById(id);
	}
	
	@RequestMapping(value = "pokemon/type", method = RequestMethod.GET)
	public @ResponseBody List<Type> allTypes(@RequestParam(value="name", required = false) String name) {
		if (name == null) {
			return typeRepository.findAll();
		} else {
			return typeRepository.findByNameContaining(name);
		}
	}

	@RequestMapping(value = "pokemon/type/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Type> TypesById(@PathVariable("id") long id) {
		return (List<Type>) typeRepository.findById(id);
	}

}
