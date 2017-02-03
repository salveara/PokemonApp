package co.com.psl.PokemonApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.psl.PokemonApp.dto.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	List<Pokemon> findByNameContaining(String name);

	Pokemon findById(Long id);

}
