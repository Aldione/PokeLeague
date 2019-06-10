package proyectoPokemon;

import java.util.ArrayList;
import java.util.List;

public class MainTournament {
	public static void main(String[] args) {
		
		Tournament torneo = new Tournament();
		
		List<Entrenador> contenders = new ArrayList<>();
		Entrenador cpuAna = new Maquina();
		cpuAna.setNombre("Ana");
		Entrenador cpuJaime = new Maquina();
		cpuJaime.setNombre("Jaime");
		Entrenador cpuTony = new Maquina();
		cpuTony.setNombre("Tony");
		Entrenador cpuJuan = new Maquina();
		cpuJuan.setNombre("Juan");
		Entrenador cpuSimon= new Maquina();
		cpuSimon.setNombre("Simon");
		Entrenador cpuJay = new Maquina();
		cpuJay.setNombre("Jay");
		Entrenador cpuJoselu = new CPUJoselu();
		cpuJoselu.setNombre("Joselu");
		Entrenador cpuMachine = new Maquina();

		//2. We add all the trainers to the contenders league
		contenders.add(cpuAna);
		contenders.add(cpuJaime);
		contenders.add(cpuTony);
		contenders.add(cpuJuan);
		contenders.add(cpuSimon);
		contenders.add(cpuJay);
		contenders.add(cpuJoselu);
		contenders.add(cpuMachine);
		
		torneo.executeTournament(contenders);
	}

}
