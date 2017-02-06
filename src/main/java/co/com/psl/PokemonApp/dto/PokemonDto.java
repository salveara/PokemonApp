package co.com.psl.PokemonApp.dto;

import java.util.List;

public class PokemonDto {
	
	private Long id;
    private String name;
    private List<String> type;
    private List<String> weakness;
    private Long evolutionId;
    private String image;

    public PokemonDto(){}

	public PokemonDto(Long id, String name, List<String> type, List<String> weakness, Long evolutionId, String image) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.weakness = weakness;
		this.evolutionId = evolutionId;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public List<String> getWeakness() {
		return weakness;
	}

	public void setWeakness(List<String> weakness) {
		this.weakness = weakness;
	}

	public Long getEvolutionId() {
		return evolutionId;
	}

	public void setEvolutionId(Long evolutionId) {
		this.evolutionId = evolutionId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	};
    
   

}
