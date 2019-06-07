package pokemon;

public interface Status {
	
	void attack(Pokemon attacker, Pokemon enemy, int attack);
	void resolveStatus(Pokemon pokemon);
}
