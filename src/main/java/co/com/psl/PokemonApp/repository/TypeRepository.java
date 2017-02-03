package co.com.psl.PokemonApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.psl.PokemonApp.dto.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
	
	List<Type> findByNameContaining(String name);

    Type findById(Long id);
}
