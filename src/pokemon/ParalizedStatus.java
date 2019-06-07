package pokemon;

public class ParalizedStatus implements Category{

	@Override
	public void attack(Pokemon enemy, Pokemon attacker, Attack attack) {
		enemy.moveToParalizedStatus();
	}



}
