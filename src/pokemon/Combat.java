package pokemon;

public class Combat {

	Trainer trainer1, trainer2;
	Pokemon pokemon1, pokemon2;
	Presenter presenter = new Presenter();
	boolean winnerShown=false;
	
	/* 0. We create the trainers
	 * 		0.1 User will be allowed to choose his nickname
	 * 		0.2 Machine will take a random nickname
	 * 1. We assign three random pokemons to each trainer
	 * 2. Trainers will get out their first pokemon of the list
	 * 		2.1 The first pokemon and it's life is shown
	 * 3. The battle starts and we enter in the turns stage
	 * 		3.1 Trainers choose indepently the movement they want to do
	 * 			3.1.1 If the trainer attacks
	 * 				3.1.1.1 We compare the speed of each pokemon, the one who has the bigger, will use his movement first, then, the other attacks
	 * 				3.1.1.2	We resolve the status of each pokemon at the end of the turn
	 * 			3.1.2 If one trainer decides to change pokemon
	 * 				3.1.2.1 The trainer who changes the pokemon will go first (Speed doesnt matter)
	 * 				3.1.2.2 The other trainer's pokemon will attack the first's new one
	 * 				3.1.2.3 We resolve the status of each pokemon at the end of the turn
	 * 			3.1.3 If one of the trainers surrender, the other automatically wins
	 * 		3.2 If one of the trainer's pokemon is died, he gets out another one (selected by the trainer) This is done before the turn selection starts
	 * 		3.3 If one of the trainers run out of pokemons, the other wins
	 */
	
	Combat(){
		
		int option1, option2;
			
		//0. We create the trainers
		trainer1=new Machine();
		trainer2=new Machine();
		
		//0.1 User will be allowed to choose his nickname
		trainer1.askName();
		//0.2 Machine will take a random nickname
		trainer2.askName();
		
		versus(trainer1, trainer2);
		
		//1. We assign three random pokemons to each trainer
		trainer1.assignPokemon();
		trainer2.assignPokemon();
		
		//2. Trainers will get out their first pokemon of the list
		pokemon1=trainer1.pokeTeam.get(0);
		pokemon2=trainer2.pokeTeam.get(0);
		//2.1 The first pokemon and it's life is shown
		pokemon1.showHealth();
		pokemon2.showHealth();
		
		//3. The battle starts and we enter in the turns stage
		do {
			//3.1 Trainers choose indepently what they want to do					//The first option will be attack
			option1=trainer1.requestOption();										//The second option will be change the pokemon
			option2=trainer2.requestOption();										//The third option will be surrender
			
			if(!anySurrender(trainer1, option1, trainer2, option2)) {
				if(!anyChange(trainer1, option1, trainer2, option2)) {
					bothAttack(trainer1, trainer2);
				}
			}
			
			//We check if both trainers have at least one pokemon living in their teams
			trainer1.teamAlive=trainer1.checkTeamLife();
			trainer2.teamAlive=trainer2.checkTeamLife();
		
			
		}while(!trainer1.surrender && !trainer2.surrender && trainer1.teamAlive && trainer2.teamAlive);
		
		
		if(!trainer1.surrender || !trainer2.teamAlive) {
			showWinner(trainer1);
		} else if(!trainer2.surrender || !trainer1.teamAlive) {
			showWinner(trainer2);
		}else if(trainer1.checkTeamLife()==false){
			showWinner(trainer2);
		}else if(trainer2.checkTeamLife()==false){
			showWinner(trainer1);
			
		} 
	}

	
	
	private void versus(Trainer trainer1, Trainer trainer2) {
		presenter.versus(trainer1, trainer2);
	}



	private void showWinner(Trainer trainer) {
		presenter.showWinner(trainer);
	}

	//This method will be executed when no one of the trainers want to change a pokemon or surrender, so it will check what pokemon is faster and this one will attack first and then,
	// 		if the pokemon doesnt die, the other attacks.
	private void bothAttack(Trainer trainer1, Trainer trainer2) {
			
		if(pokemon1.getSpeed()>pokemon2.getSpeed()) {	//As pokemon1 is faster, he will attack first
			pokemon1.attack(trainer1.requestAttack(pokemon1), pokemon2);
			int aux=trainer2.requestAttack(pokemon2); //We save the attack decided by trainer2 to use it or not, depending on if his pokemon die.
			//If pokemon1 kills pokemon2, we will show the pokemon1 health and we will ask the trainer2 for another pokemon to continue
			if(pokemon2.getHealth()<=0) {
				pokemon2.moveToDiedStatus();	//This method wills how the trianer that his pokemon has died
				if(trainer2.checkTeamLife()){
					pokemon2=trainer2.pokeTeam.get(trainer2.requestPokemon());
				}
			//If pokemon1 doesnt kill pokemon2, pokemon2 will proceed with the attack
			} else {
				pokemon2.attack(aux, pokemon1);
				if(pokemon1.getHealth()<=0) {
					pokemon1.moveToDiedStatus();
					if(trainer1.checkTeamLife()) {
						pokemon1=trainer1.pokeTeam.get(trainer1.requestPokemon());
					}
				}
			}
			//We resolve the status from each pokemon
			pokemon1.getStatus().resolveStatus(pokemon1);
			pokemon2.getStatus().resolveStatus(pokemon2);
			//We show the health status
			pokemon1.showHealth();
			pokemon2.showHealth();
		} else {	//As pokemon1 is slower, pokemon2 will attack first
			pokemon2.attack(trainer2.requestAttack(pokemon2), pokemon1);
			int aux=trainer1.requestAttack(pokemon1); //We save the attack decided by trainer1 to use it or not, depending on if his pokemon die.
			//If pokemon2 kills pokemon1, we will show the pokemon2 health and we will ask the trainer1 for another pokemon to continue
			if(pokemon1.getHealth()<=0) {
				pokemon1.moveToDiedStatus();
				if(trainer1.checkTeamLife()) {
					pokemon1=trainer1.pokeTeam.get(trainer1.requestPokemon());
				}
			//If pokemon1 doesnt kill pokemon2, pokemon2 will proceed with the attack
			} else {
				pokemon1.attack(aux, pokemon2);
				if(pokemon2.getHealth()<=0) {
					pokemon2.moveToDiedStatus();
					if(trainer2.checkTeamLife()){
						pokemon2=trainer2.pokeTeam.get(trainer2.requestPokemon());
					}
				}
			}
			
			//We resolve the status from each pokemon
			pokemon1.getStatus().resolveStatus(pokemon1);
			pokemon2.getStatus().resolveStatus(pokemon2);
			//We show the health status
			pokemon1.showHealth();
			pokemon2.showHealth();
		}
	}

	//This method will check if some of the trainers has decided to change any pokemon of the team, if yes, he will change and the other trainer will attack
	private boolean anyChange(Trainer trainer1, int option1, Trainer trainer2, int option2) {
		
		boolean anyChange=false;
		
		if(option1==2 && option2==2) {
			pokemon1=trainer1.pokeTeam.get(trainer1.requestPokemon());
			pokemon2=trainer2.pokeTeam.get(trainer2.requestPokemon());
			return true;
		} else if (option1==2 && option2!=2){
			//Trainer 1 changes his pokemon
			pokemon1=trainer1.pokeTeam.get(trainer1.requestPokemon());
			int selectedAttack=trainer2.requestAttack(pokemon2);			//We save the attack selected to maintain the order of the turn
			pokemon1.showHealth();
			pokemon2.attack(selectedAttack, pokemon1);
			pokemon1.getStatus().resolveStatus(pokemon1);
			pokemon2.getStatus().resolveStatus(pokemon2);
			return true;
		} else if (option2==2 && option1!=2) {
			//Trainer 1 changes his pokemon
			pokemon2=trainer2.pokeTeam.get(trainer2.requestPokemon());
			int selectedAttack=trainer1.requestAttack(pokemon1);			//We save the attack selected to maintain the order of the turn
			pokemon2.showHealth();
			pokemon1.attack(selectedAttack, pokemon2);
			pokemon1.getStatus().resolveStatus(pokemon1);
			pokemon2.getStatus().resolveStatus(pokemon2);
			return true;
		}
		
		
		return anyChange;
	}

	//This method will check if some of the trainers has surrender
	private boolean anySurrender(Trainer trainer1, int option1, Trainer trainer2, int option2) {
		
		boolean anySurrender=false;
		
		if(option1==3) {
			trainer1.surrender();
			return true;
		} else if(option2==3) {
			trainer2.surrender();
			return true;
		}
			
		return anySurrender;
	}
}
