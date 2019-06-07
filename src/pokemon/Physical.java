package pokemon;

public class Physical implements Category{

	public void attack(Pokemon enemy, Pokemon attacker, Attack attack) {
			
		enemy.setHealth(enemy.getHealth()-calculateHurt(enemy, attacker, attack));
	}

	private int calculateHurt(Pokemon enemy, Pokemon attacker, Attack attack) {
		
		/*
			N: Level of the attacker
			A: Amount of the attack. If the attack is physical, we take the amount of the attack
				and if it's special, we take the amount of the special attack.
			P: Power of the attack
			D: Amount of defense from the enemy.
			B: Bonification. If the attack is from the same kind as the pokemon, we take 1.5, if not,
				we take 1.
			E: Effectivity. Random valor (0, 0.25, 0.5, 1, 2, 4)
			V: Variation. Valor between 85 and 100.
		 */
		
		int hurt=0, variation=(int) ((Math.random() * ((100 - 85) + 1)) + 85);
		final int N=50;
		double a=0, p=0, d=0, b=0, e=0;
		
		
		//Bonification calculation
		if(attack.getType()==attacker.specie.type || attack.getType()==attacker.specie.subType) {
			b=1.5;
		} else {
			b=1;
		}
		
		//Efectivity calculation
		e=attack.getEfectivities().get(enemy.getSpecie().getType());
		//Power calculation
		p=attack.getPower();
		//Defense calculation
		d=enemy.getSpecie().getDefense();
		//Attack calculation
		a=attacker.getSpecie().getAttack();
		
		
		//HURT CALCULATION
		double z = (0.01*b*e*variation);
		double x = (0.2*N+1);
		double y = (a*p);
		double h = (25*d);
		hurt=(int)(z* (((x*y)/h) +2));
		
		//This method shows the hurt done
		attacker.showHurtToTheEnemy(enemy, hurt);
		
		
		return hurt;
	}

}
