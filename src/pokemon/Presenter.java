package pokemon;

public class Presenter {

	PresenterView view=new View();
	
	Presenter(){
	}
	
	public int requestOption() {
		return view.requestOption();
	}
	
	public String requestName() {
		return view.requestName();
	}
	
	public int requestPokemon(Trainer trainer) {
		return view.requestPokemon(trainer);
	}
	
	public int requestAttack(Pokemon pokemon) {
		return view.requestAttack(pokemon);
	}
	
	public void showHealth(Pokemon pokemon) {
		view.showHealth(pokemon);
	}
	
	public void hasDied(Pokemon pokemon) {
		view.hasDied(pokemon);
	}
	
	public void showWinner(Trainer trainer) {
		view.showWinner(trainer);
	}

	public void noMoreStates(Pokemon pokemon) {
		view.noMoreStates(pokemon);
	}

	public void isPoisoned(Pokemon pokemon) {
		view.isPoisoned(pokemon);
	}

	public void isSlept(Pokemon pokemon) {
		view.isSlept(pokemon);
	}

	public void isParalized(Pokemon pokemon) {
		view.isParalized(pokemon);
	}

	public void dontAttackParalized(Pokemon attacker) {
		view.dontAttackParalized(attacker);
	}

	public void lifeLostPoisoned(Pokemon pokemon) {
		view.lifeLostPoisoned(pokemon);
	}

	public void dontAttackSlept(Pokemon pokemon) {
		view.dontAttackSlept(pokemon);
	}

	public void showHurtToTheEnemy(Pokemon attacker, Pokemon enemy, int hurt) {
		view.showHurtToTheEnemy(attacker, enemy, hurt);
	}

	public void isDied(Pokemon pokemon) {
		view.isDied(pokemon);
	}

	public void versus(Trainer trainer1, Trainer trainer2) {
		view.versus(trainer1,trainer2);
	}

	public void attackFailed(Pokemon pokemon) {
		view.attackFailed(pokemon);
	}
}
