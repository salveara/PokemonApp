package co.com.psl.PokemonApp.RepositoryTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.psl.PokemonApp.dto.Pokemon;
import co.com.psl.PokemonApp.dto.Type;
import co.com.psl.PokemonApp.repository.PokemonRepository;
import co.com.psl.PokemonApp.repository.TypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PokemonRepositoryTest {

	Pokemon charmander; 
	
	@Autowired
	PokemonRepository pokemonRepository;
	@Autowired
	private TypeRepository typeRepository;
	
	@Before
	public void init(){
		charmander = new Pokemon(1L, "Charmander", null, null, null,
				"http://vignette1.wikia.nocookie.net/es.pokemon/images/5/56/Charmander.png?cb=20140207202456");
		pokemonRepository.saveAndFlush(charmander);
	}
	
	@Test
	public void savePokemon() {
		List<Pokemon> pokemon = pokemonRepository.findByNameContaining("Charmander");
		String test = pokemon.get(0).getName();
		assertEquals("Charmander", test);
	}

	@Test
	public void saveEvolution() {
		Pokemon charmeleon = new Pokemon(2L, "Charmeleon", null, null, null,
				"http://vignette2.wikia.nocookie.net/es.pokemon/images/f/fb/Charmeleon.png?cb=20140207202536");
		pokemonRepository.save(charmeleon);
		charmander.setEvolution(charmeleon);
		pokemonRepository.save(charmander);
		pokemonRepository.flush();
		List<Pokemon> pokemon = pokemonRepository.findByNameContaining("Charmander");
		String test = pokemon.get(0).getEvolution().getName();
		assertEquals("Charmeleon", test);
	}

	@Test
	public void saveType() {
		typeRepository.saveAndFlush(new Type(1L, "Fire"));
		List<Type> types = new ArrayList<Type>();
		types.add(typeRepository.findById(1L));
		charmander.setType(types);
		pokemonRepository.saveAndFlush(charmander);
		List<Pokemon> pokemon = pokemonRepository.findByNameContaining("Charmander");
		String test = pokemon.get(0).getType().get(0).getName();
		assertEquals("Fire", test);
	}
}
