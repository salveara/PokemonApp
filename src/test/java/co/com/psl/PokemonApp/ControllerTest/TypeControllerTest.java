package co.com.psl.PokemonApp.ControllerTest;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class TypeControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	 public void getAllTypes() throws Exception{
		 this.mockMvc.perform(get("/pokemon/type"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$", hasSize(7)));
	 }

	 @Test
	 public void getTypeByName() throws Exception{
		 this.mockMvc.perform(get("/pokemon/type").param("name", "Ele"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$", hasSize(1)))
		 .andExpect(jsonPath("$[0].name").value("Electric"));
	 }
	 
	 @Test
	 public void getTypeById() throws Exception{
		 this.mockMvc.perform(get("/pokemon/type/1"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$").exists())
		 .andExpect(jsonPath("$.name").value("Electric"));
	 }

}
