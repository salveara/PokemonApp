package co.com.psl.PokemonApp.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.psl.PokemonApp.dto.Pokemon;
import co.com.psl.PokemonApp.dto.PokemonDto;
import co.com.psl.PokemonApp.dto.Type;
import co.com.psl.PokemonApp.repository.PokemonRepository;
import co.com.psl.PokemonApp.repository.TypeRepository;

@Component
public class PokemonInit {

	@Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private TypeRepository typeRepository;

	@PostConstruct
	public void dataInit() {
		typeRepository.save(new Type(1L, "Electric"));
		typeRepository.save(new Type(2L, "Ground"));
		typeRepository.save(new Type(3L, "Rock"));
		typeRepository.save(new Type(4L, "ground"));
		typeRepository.save(new Type(5L, "Grass"));
		typeRepository.save(new Type(6L, "Poison"));
		typeRepository.save(new Type(7L, "Fire"));
		typeRepository.flush();

		List<Type> types = new ArrayList<Type>();
		types.add(typeRepository.findById(1L));
		
		List<Type> weaknesses = new ArrayList<Type>();
		weaknesses.add(typeRepository.findById(2L));
		weaknesses.add(typeRepository.findById(3L));
		
		Pokemon pikachu = new Pokemon(1L, "Pikachu", types, weaknesses, null,
				"http://cdn.bulbagarden.net/upload/0/0d/025Pikachu.png");
		pokemonRepository.save(pikachu);
		Pokemon raichu = new Pokemon(2L, "Raichu", types, weaknesses, null,
				"http://cdn.bulbagarden.net/upload/8/88/026Raichu.png");
		pokemonRepository.save(raichu);

		types = new ArrayList<Type>();
		types.add(typeRepository.findById(5L));
		types.add(typeRepository.findById(6L));
		
		weaknesses = new ArrayList<Type>();
		weaknesses.add(typeRepository.findById(7L));
		
		Pokemon bulbasaur = new Pokemon(3L, "Bulbasaur", types, weaknesses, null,
				"http://cdn.bulbagarden.net/upload/2/21/001Bulbasaur.png");
		pokemonRepository.save(bulbasaur);
		
		pikachu.setEvolution(raichu);
		pokemonRepository.save(pikachu);
		pokemonRepository.flush();
	}

}
