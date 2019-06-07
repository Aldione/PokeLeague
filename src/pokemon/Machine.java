package pokemon;

import java.util.Random;

public class Machine extends Trainer{

	Random r = new Random();
	
	@Override
	String requestName() {
		String[] nicknames= {"Tony el llorón", "Jaime el Caterpie", "Eva programmer", "Pedro la Joyita"};
		
		int rnd = r.nextInt(nicknames.length-0) + 0;
		
		return nicknames[rnd];
	}

	@Override
	int requestOption() {
		int rnd = r.nextInt(2-1) + 1;
		
		return rnd;
	}

	@Override
	int requestAttack(Pokemon pokemon) {
		int rnd = r.nextInt(4-1) + 1;
		
		return rnd;
	}

	@Override
	int requestPokemon() {
		
		int rnd;
		
		do {
			rnd = r.nextInt(3);
		}while(this.pokeTeam.get(rnd).getStatus() instanceof Died);
		
		return rnd;
	}


}
