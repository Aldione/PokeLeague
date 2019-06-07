package pokemon;

public class Healthy implements Status{
	
	@Override
	public void attack(Pokemon attacker, Pokemon enemy, int attack) {
	
		int rnd = (int) (Math.random() * 100) + 1;
		
		if(rnd <= attacker.getSpecie().getAttack(attack).getPrecision()) {
			attacker.getSpecie().getAttack(attack).attack(attacker, enemy);
		} else {
			attacker.attackFailed();
		}
	}

	//As the pokemon is healthy, we dont resolve his status because he won't have any secundary effects
	public void resolveStatus(Pokemon pokemon) {
	}

}
