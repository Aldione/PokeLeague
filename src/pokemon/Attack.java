package pokemon;

import java.util.HashMap;
import java.util.Map;

public class Attack {
	
	private String attackName;
	private int power;
	private int precision;
	private Category category;
	private Type type;
	private Map<Type, Double> efectivities=new HashMap();


	public Attack(String attackName, int power, int precision, String category, Type type, Map<Type, Double> efectivities){
		
		this.attackName= attackName;
		this.power=power;
		this.precision=precision;
		this.category=asignCategory(category);
		this.type=type;
		this.efectivities=efectivities;
	}


	/*This method will asign a category depending on the string*/
	private Category asignCategory(String c) {
		switch (c) {
		case "ESTADOENV":
			return new PoisonedStatus();
		case "ESTADODOR":
			return new SleptStatus();
		case "FISICO":
			return new Physical();
		case "ESPECIAL":
			return new Special();
		case "ESTADOPAR":
			return new ParalizedStatus();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	void attack(Pokemon attacker, Pokemon enemy) {
		category.attack(enemy, attacker, this);
	}

	/* ----------- GETTERS AND SETTERS --------------*/
	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Map<Type, Double> getEfectivities() {
		return efectivities;
	}
	
	public int getPower() {
		return power;
	}

	public void setCategory(Category category) {
		this.category=category;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public String toString() {
		return String.format(attackName);
	}

	public int getPrecision() {
		return precision;
	}
	
}
