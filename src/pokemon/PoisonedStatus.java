package pokemon;

public class PoisonedStatus implements Category{

	@Override
	public void attack(Pokemon enemy, Pokemon attacker, Attack attack) {
		enemy.moveToPoisonedStatus();
	}

	
}
