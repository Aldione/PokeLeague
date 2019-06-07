package pokemon;

public class SleptStatus implements Category{

	@Override
	public void attack(Pokemon enemy, Pokemon attacker, Attack attack) {
		
			enemy.moveToSleptStatus();
	}
}
