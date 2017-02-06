package co.com.psl.PokemonApp.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.com.psl.PokemonApp.configuration.PokemonAdapter;
import co.com.psl.PokemonApp.dto.Pokemon;
import co.com.psl.PokemonApp.dto.PokemonDto;
import co.com.psl.PokemonApp.dto.Type;

public class PokemonAdapterTest {

	PokemonAdapter pokemonAdapter;
	Pokemon meow;
	List<Type> types;
	
	@Before
	public void init(){
		pokemonAdapter = new PokemonAdapter();
		types = new ArrayList<Type>();
		types.add(new Type(1L, "Psych"));
		meow = new Pokemon(1L, "Meow", types, null, null, "www.imagenmeow.com");
	}
	
	@Test
	public void typesToString(){
		String result = pokemonAdapter.typesToString(types).get(0);
		assertEquals("Psych", result);
	}
	
	@Test
	public void pokemonToPokemonDto() {
		PokemonDto meowDto = pokemonAdapter.pokemonToPokemonDto(meow);
		String result = meowDto.getType().get(0);
		assertEquals("Psych", result);
	}

}
