package pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class Trainer {

	String name;
	int option, selectedAttack, pokemonSelected;
	boolean surrender, teamAlive, winner=false, defeated=false;
	PokemonFactory pokemonFactoryRandomized=new PokemonFactoryRandomized();
	Presenter presenter=new Presenter();
	List<Pokemon> pokeTeam=new ArrayList<Pokemon>();
	abstract String requestName();
	abstract int requestOption();
	abstract int requestAttack(Pokemon pokemon);
	abstract int requestPokemon();
	
	
	/*---- BASIC METHOS THAT ARE THE SAME FOR ALL THE TRAINERS ----*/
	
	//This method checks if the team is alive, we consider that a team is alive if just one of the pokemons has more than 0 as health
	boolean checkTeamLife() {
		if(pokeTeam.get(0).getHealth()>0 || pokeTeam.get(1).getHealth()>0 || pokeTeam.get(2).getHealth()>0) {
			teamAlive=true;
			return true;
		} else {
			teamAlive=false;
			return false;
		}
	}
	
	//This method assigns 3 pokemon to the trainer's team
	public void assignPokemon() {
		
		Pokemon auxPokemon=pokemonFactoryRandomized.create();
		Pokemon auxPokemon2=pokemonFactoryRandomized.create();
		Pokemon auxPokemon3=pokemonFactoryRandomized.create();
		
		//We add the first pokemon to the team
		pokeTeam.add(auxPokemon);
		
		//We check if the specie of the second pokemon is the same as the specie of the first pokemon, if yes, we change it till the species are different
		if(auxPokemon2.getSpecie().equals(auxPokemon.getSpecie())) {
			do {
				auxPokemon2=pokemonFactoryRandomized.create();
			}while(auxPokemon2.getSpecie().equals(auxPokemon.getSpecie()));
		}
		
		//If they are not the same, we add the pokemon to the team
		pokeTeam.add(auxPokemon2);
	
		//We check if the specie of the third pokemon is the same as the specie of the two first pokemon, if yes, we change it till the species are different
		if(auxPokemon3.getSpecie().equals(auxPokemon2.getSpecie()) || auxPokemon3.getSpecie().equals(auxPokemon.getSpecie())) {
			do {
				auxPokemon2=pokemonFactoryRandomized.create();
			}while(auxPokemon3.getSpecie().equals(auxPokemon2.getSpecie()) || auxPokemon3.getSpecie().equals(auxPokemon.getSpecie()));
		}	
		
		//If they are not the same, we add the pokemon to the team
		pokeTeam.add(auxPokemon3);
		
	}
	
	//This method sets the surrender option to true
	void surrender() {
		surrender=true;
	}
	
	//This method sets the nickname of each trainer
	void askName() {
		name=requestName();
	}
	public String getName() {
		return name;
	}
	

	
}
