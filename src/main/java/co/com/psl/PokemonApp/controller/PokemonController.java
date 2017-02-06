package co.com.psl.PokemonApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.psl.PokemonApp.configuration.PokemonAdapter;
import co.com.psl.PokemonApp.dto.Pokemon;
import co.com.psl.PokemonApp.dto.PokemonDto;
import co.com.psl.PokemonApp.repository.PokemonRepository;

@RestController
public class PokemonController {

	@Autowired
	private PokemonRepository pokemonRepository;

	@Autowired
	private PokemonAdapter pokemonAdapter = new PokemonAdapter();

	@RequestMapping(value = "/pokemon", method = RequestMethod.GET)
	public @ResponseBody List<PokemonDto> allPokemon(@RequestParam(value = "name", required = false) String name) {
		List<Pokemon> pokemonList;
		if (name == null) {
			pokemonList = pokemonRepository.findAll();
			return pokemonAdapter.pokemonDtoToList(pokemonList);
		} else {
			pokemonList = pokemonRepository.findByNameContaining(name);
			return pokemonAdapter.pokemonDtoToList(pokemonList);
		}
	}

	@RequestMapping(value = "/pokemon/{id}", method = RequestMethod.GET)
	public @ResponseBody PokemonDto PokemonById(@PathVariable("id") long id) {
		Pokemon pokemon = pokemonRepository.findById(id);
		return pokemonAdapter.pokemonToPokemonDto(pokemon);
	}



}
