package co.com.psl.PokemonApp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;
	 
	 @Test
	 public void GetAllPokemon() throws Exception{
		 this.mockMvc.perform(get("/pokemon"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$", hasSize(3)));
	 }
	 
	 @Test
	 public void GetPokemonByName() throws Exception{
		 this.mockMvc.perform(get("/pokemon").param("name", "Pika"))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$", hasSize(1)))
         .andExpect(jsonPath("$[0].id").value("1"))
         .andExpect(jsonPath("$[0].name").value("Pikachu"));
	 }
	 
	 @Test
	 public void GetPokemonById() throws Exception{
		 this.mockMvc.perform(get("/pokemon/3"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$", hasSize(1)))
		 .andExpect(jsonPath("$[0].id").value("3"))
		 .andExpect(jsonPath("$[0].name").value("Bulbasour"));
	 }

	 @Test
	 public void GetAllType() throws Exception{
		 this.mockMvc.perform(get("/pokemon/type"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$", hasSize(7)));
	 }

	 @Test
	 public void GetTypeBynName() throws Exception{
		 this.mockMvc.perform(get("/pokemon/type").param("name", "Ele"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$", hasSize(1)))
		 .andExpect(jsonPath("$[0].type").value("Electric"));
	 }
	 
	 @Test
	 public void GetTypeBynId() throws Exception{
		 this.mockMvc.perform(get("/pokemon/type/1"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$", hasSize(1)))
		 .andExpect(jsonPath("$[0].type").value("Electric"));
	 }

}
