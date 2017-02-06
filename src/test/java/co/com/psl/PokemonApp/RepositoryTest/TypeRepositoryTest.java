package co.com.psl.PokemonApp.RepositoryTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.psl.PokemonApp.dto.Type;
import co.com.psl.PokemonApp.repository.TypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TypeRepositoryTest {

	@Autowired
	private TypeRepository typeRepository;

	@Before
	public void init(){
		typeRepository.save(new Type(1L, "Fairy"));
		typeRepository.save(new Type(2L, "Normal"));
		typeRepository.flush();
	}
	
	@Test
	public void findById() {
		Type type = typeRepository.findById(2L);
		String result = type.getName();
		assertEquals("Normal", result);
	}

	@Test
	public void findByNameContainig() {
		Type type = typeRepository.findByNameContaining("Fai").get(0);
		String result = type.getName();
		assertEquals("Fairy", result);
	}

	/*@Test
	public void findAll() {
		List<Type> types = typeRepository.findAll();
		int result = types.size();
		assertEquals(2, result);
	}*/

}
