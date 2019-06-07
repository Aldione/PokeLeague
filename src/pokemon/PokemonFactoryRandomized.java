package pokemon;

import java.util.Random;

public class PokemonFactoryRandomized extends PokemonFactory{

	public Pokemon create() {

		int rnd;
		Random r = new Random();
		
		//We generate a random number to take one specie
		rnd=r.nextInt(database.getSpecies().size())+1;
		
		return new Pokemon(database.getSpecies().get(rnd));
	}

}
