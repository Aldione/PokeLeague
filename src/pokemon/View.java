package pokemon;

import claseTeclado.Colores;
import claseTeclado.Keyboard;
import claseTeclado.Keyboard.Range;

public class View implements PresenterView{

	/* ----------------------------------- */
	
	/*     REQUESTING MESSAGES METHODS     */
	
	/* ----------------------------------- */
	@Override
	public String requestName() {
		
		String name=Keyboard.readString("Choose your nickname");
		return name;
	}

	@Override
	public int requestOption() {
		
		int option;
		
		System.out.println("\nPlease, select what you want to do this turn:\n 1.Attack!"
				+ "														   \n 2.Change pokemon"
				+ "														   \n 3.Surrender");
		option=Keyboard.readRange(1, 3, Range.BOTHINCLUDED);
		
		return option;
	}

	@Override
	public int requestPokemon(Trainer trainer) {
		
		int option;
		
		do {
			System.out.println("\nPlease, select the pokemon you want to go on with:\n 1." + trainer.pokeTeam.get(0).getSpecie().getName() + " - Health: " + trainer.pokeTeam.get(0).getHealth() +
																				   "\n 2." + trainer.pokeTeam.get(1).getSpecie().getName() + " - Health: " + trainer.pokeTeam.get(1).getHealth() +
																				   "\n 3." + trainer.pokeTeam.get(2).getSpecie().getName() + " - Health: " + trainer.pokeTeam.get(2).getHealth());
			
			option=Keyboard.readRange(1, 3, Range.BOTHINCLUDED)-1;
			
			if(trainer.pokeTeam.get(option).getStatus() instanceof Died) {
				System.out.println("You can't get a pokemon that is died!");
			}
			
		}while(trainer.pokeTeam.get(option).getStatus() instanceof Died);
		
		return option;
	}

	@Override
	public int requestAttack(Pokemon pokemon) {
		
		int option;
		
		System.out.println("\nPlease, select the attack you want to go on with: \n 1." + pokemon.getSpecie().getAttackList().get(0).toString() +
				   															   "\n 2." + pokemon.getSpecie().getAttackList().get(1).toString() +
				   															   "\n 3." + pokemon.getSpecie().getAttackList().get(2).toString() +
				   															   "\n 4." + pokemon.getSpecie().getAttackList().get(3).toString());

		option=Keyboard.readRange(1, 4, Range.BOTHINCLUDED)-1;
	
		return option;
	}

	
	/* ----------------------------------- */
	
	/*    JUST SENDING MESSAGES METHODS    */
	
	/* ----------------------------------- */
	
	
	//Method that shows the name of the pokemon and the life of it
	public void showHealth(Pokemon pokemon) {
		//If the pokemon's life is bigger than the 70% of his total life, we show it in green
		if(pokemon.getHealth() > 0.7*pokemon.getSpecie().getHealth()) {
			System.out.println("The pokemon " + pokemon.getSpecie().getName() + " has " + Colores.VERDE + pokemon.getHealth() + Colores.RESET + " life points");
		//If the pokemon's life is bigger than the 40% of his total life, and smaller than 70%, we show it in yellow
		} else if(pokemon.getHealth()<0.7*pokemon.getSpecie().getHealth() && pokemon.getHealth()>0.4*pokemon.getSpecie().getHealth()) {
			System.out.println("The pokemon " + pokemon.getSpecie().getName() + " has " + Colores.AMARILLO + pokemon.getHealth() + Colores.RESET + " life points");
		} else {
			//If the pokemon's life is smaller than the 40% of his total life, we show it in red
			System.out.println("The pokemon " + pokemon.getSpecie().getName() + " has " + Colores.ROJO + pokemon.getHealth() + Colores.RESET + " life points.");
		}
	}

	//This method announces that a pokemon has died.
	public void hasDied(Pokemon pokemon) {
		System.out.println("The pokemon " + pokemon.getSpecie().getName() + " has died");
	}

	//This method announces what trainer won
	public void showWinner(Trainer trainer) {
		System.out.print(Colores.AZUL + "-------------------------------------------------------\n "+ trainer.getName() + " HAS WON THE GAME \n-------------------------------------------------------"+ Colores.RESET);
	}

	//This method says that the pokemon can't have more than one status
	public void noMoreStates(Pokemon pokemon) {
		System.out.println(pokemon.getSpecie().getName() + " can't have more than one status!");
	}

	//This method announces that your pokemon is poisoned
	public void isPoisoned(Pokemon pokemon) {
		System.out.println(Colores.MORADO + pokemon.getSpecie().getName() + Colores.RESET + " is now poisoned!");
	}

	//This method announces that your pokemon is slept
	public void isSlept(Pokemon pokemon) {
		System.out.println(Colores.CELESTE + pokemon.getSpecie().getName() + Colores.RESET + " is now sleping zZzZzZ");
	}

	//This method announces that your pokemon is paralized
	public void isParalized(Pokemon pokemon) {
		System.out.println(Colores.AMARILLO + pokemon.getSpecie().getName() + Colores.RESET + " is now paralized!");
	}

	//This method announces that your pokemon is healthy
	public void isHealthy(Pokemon pokemon) {
		System.out.println(Colores.VERDE + pokemon.getSpecie().getName() + Colores.RESET + " is now healthy!");
	}

	//This method announces that your pokemon couldnt attack because he is paralized
	public void dontAttackParalized(Pokemon pokemon) {
		System.out.print("Oh, you couldn't attack because " + Colores.AMARILLO + pokemon.getSpecie().getName() + Colores.RESET + " is paralized!\n");
	}

	//This method announces that your pokemon lost life because of poison
	public void lifeLostPoisoned(Pokemon pokemon) {
		System.out.println(Colores.MORADO + pokemon.getSpecie().getName() + Colores.RESET + " lost life because of poison!");
	}

	//This method announces that your pokemon couldnt attack because he is paralized
	public void dontAttackSlept(Pokemon pokemon) {
		System.out.print("Oh, you couldn't attack because " + Colores.CELESTE + pokemon.getSpecie().getName() + Colores.RESET + " is sleeping zZzZzZzZ\n");
	}

	//This method shows the amount of hurt done to the enemy
	public void showHurtToTheEnemy(Pokemon attacker, Pokemon enemy, int hurt) {
		if(hurt==0) {
			System.out.println("The attack of " + attacker.getSpecie().getName() + " was not effective against " + enemy.getSpecie().getName());
		} else {
			System.out.println(attacker.getSpecie().getName() + " has inflicted " + hurt + " to " + enemy.getSpecie().getName());
		}
	}

	//This method shows that the pokemon has died
	public void isDied(Pokemon pokemon) {
		System.out.println(Colores.ROJO + " -- " + pokemon.getSpecie().getName() + " has died --" + Colores.RESET);
	}

	//This method introduces the combat
	public void versus(Trainer trainer1, Trainer trainer2) {
		System.out.println("- PREPARE FOR THE BATTLE\n- " + trainer1.getName() + " VS " + trainer2.getName() + " \n- READY? GO!");
	}

	//This methdo shows that the pokemon failed his attack
	public void attackFailed(Pokemon pokemon) {
		System.out.println(pokemon.getSpecie().getName() + " failed his attack!");
	}
	
}
