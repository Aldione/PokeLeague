package pokemon;


import java.util.IntSummaryStatistics;
import java.util.Random;




public class CPUJoselu extends Trainer{

	private Random rnd = new Random();
	


	@Override
	String requestName() {
		return "Joselu";
	}

	@Override
	int requestOption() {
		int option = rnd.nextInt(2-1) + 1;
		
		return option;
	}

	@Override
	int requestAttack(Pokemon pokemon) {
		//Plantear logica del ataque para la IA.
		int chooseAttack = 0;
		IntSummaryStatistics powerMax = pokemon.getSpecie().getAttackList().stream()
										   				  			       .mapToInt(attack -> attack.getPower())
										   				                   .summaryStatistics();
		for(int x = 0; x < pokemon.getSpecie().getAttackList().size(); x++) {
			if(pokemon.getSpecie().getAttackList().get(x).getPower() == powerMax.getMax()) {
				chooseAttack = x;
			}
		}
		return chooseAttack;
	}

	@Override
	int requestPokemon() {
		int pokemon;
		do {
			pokemon = rnd.nextInt(3);
		}while(this.pokeTeam.get(pokemon).getStatus() instanceof Died);
		
		return pokemon;
	}

}
