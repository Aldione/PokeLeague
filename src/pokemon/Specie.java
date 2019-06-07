package pokemon;

import java.util.List;

public class Specie {

	private int health, attack, specialAttack, defense, specialDefense, speed;
	private String name;
	Type type, subType;
	private List<Attack> attackList;
	
	
	public String getName() {
		return name;
	}

	public Specie(String name, int health, int attack, int defense, int specialAttack, int specialDefense, int speed, Type type, Type subType, List<Attack> attackList) {
		this.name=name;
		this.health=health;
		this.attack=attack;
		this.defense=defense;
		this.specialAttack=specialAttack;
		this.specialDefense=specialDefense;
		this.speed=speed;
		this.type=type;
		this.subType=subType;
		this.attackList=attackList;
	}

	public int getHealth() {
		return health;
	}

	public int getSpeed() {
		return speed;
	}

	public Type getType() {
		return type;
	}

	public int getDefense() {
		return defense;
	}
	
	public int getSpecialDefense(){
		return specialDefense;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public Attack getAttack(int a) {
		return attackList.get(a);
	}

	public double getSpecialAttack() {
		return specialAttack;
	}
	
	public List<Attack> getAttackList() {
		return attackList;
	}
	
	public boolean equals(Object specie) {
		boolean result=false;
		
		if(specie instanceof Specie && name.equals(((Specie)specie).name)){
			result=true;
		}
		return result;
	}
}
