package co.com.psl.PokemonApp.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.psl.PokemonApp.dto.Pokemon;
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
		typeRepository.save(new Type(1L, "normal"));
		typeRepository.save(new Type(2L, "flying"));
		typeRepository.save(new Type(3L, "poison"));
		typeRepository.save(new Type(4L, "ground"));
		typeRepository.save(new Type(5L, "fire"));
		typeRepository.save(new Type(6L, "grass"));
		typeRepository.save(new Type(7L, "electric"));
		typeRepository.save(new Type(8L, "psychic"));
		typeRepository.save(new Type(9L, "ice"));
		typeRepository.flush();

		List<Type> pikachuTypes = new ArrayList<Type>();
		pikachuTypes.add(typeRepository.findById(7L));
		List<Type> pikachuWeaknesses = new ArrayList<Type>();
		pikachuWeaknesses.add(typeRepository.findById(4L));
		Pokemon pikachu = new Pokemon("Pikachu", pikachuTypes, pikachuWeaknesses, null,
				"http://cdn.bulbagarden.net/upload/0/0d/025Pikachu.png");

		List<Type> bulbasaurTypes = new ArrayList<Type>();
		bulbasaurTypes.add(typeRepository.findById(6L));
		bulbasaurTypes.add(typeRepository.findById(3L));
		List<Type> bulbasaurWeaknesses = new ArrayList<Type>();
		bulbasaurWeaknesses.add(typeRepository.findById(5L));
		bulbasaurWeaknesses.add(typeRepository.findById(9L));
		bulbasaurWeaknesses.add(typeRepository.findById(2L));
		bulbasaurWeaknesses.add(typeRepository.findById(8L));
		Pokemon bulbasaur = new Pokemon("Bulbasaur", bulbasaurTypes, bulbasaurWeaknesses, null,
				"http://cdn.bulbagarden.net/upload/2/21/001Bulbasaur.png");
		Pokemon raichu = new Pokemon("Raichu", pikachuTypes, pikachuWeaknesses, null,
				"http://cdn.bulbagarden.net/upload/8/88/026Raichu.png");
		pokemonRepository.save(pikachu);
		pokemonRepository.save(bulbasaur);
		pokemonRepository.save(raichu);
		pikachu.setEvolution(raichu);
		pokemonRepository.saveAndFlush(pikachu);
	}

}
