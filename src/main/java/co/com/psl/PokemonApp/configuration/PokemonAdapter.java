package co.com.psl.PokemonApp.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.psl.PokemonApp.dto.Pokemon;
import co.com.psl.PokemonApp.dto.PokemonDto;
import co.com.psl.PokemonApp.dto.Type;

@Component
public class PokemonAdapter {

	public PokemonDto pokemonToPokemonDto(Pokemon pokemon) {
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setId(pokemon.getId());
		pokemonDto.setName(pokemon.getName());
		if (pokemon.getEvolution() != null)
			pokemonDto.setEvolutionId(pokemon.getEvolution().getId());
		pokemonDto.setImage(pokemon.getImage());
		if (pokemon.getType() != null)
			pokemonDto.setType(typesToString(pokemon.getType()));
		if (pokemon.getWeakness() != null)
			pokemonDto.setWeakness(typesToString(pokemon.getWeakness()));
		return pokemonDto;
	}

	public List<PokemonDto> pokemonDtoToList(List<Pokemon> pokemonList) {
		List<PokemonDto> pokemonDto = new ArrayList<PokemonDto>();
		for (int i = 0; i < pokemonList.size(); i++) {
			pokemonDto.add(pokemonToPokemonDto(pokemonList.get(i)));
		}
		return pokemonDto;
	}

	public List<String> typesToString(List<Type> types) {
		List<String> typeList = new ArrayList<String>();
		for (int i = 0; i < types.size(); i++) {
			typeList.add(types.get(i).getName());
		}
		return typeList;
	}

}
