package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import claseTeclado.Keyboard;

public class Tournament {

	Presenter presenter=new Presenter();
	Random r = new Random();
	List<Trainer> contenders=new ArrayList<Trainer>();
	private Trainer cpuAna;
	private Trainer cpuJaime;
	private Trainer cpuTony;
	private Trainer cpuJuan;
	private Trainer cpuSimon;
	private Trainer cpuJay;
	private Trainer cpuJoselu;
	private Trainer cpuMachine;
	private int nPhases;
	//nFases
	
	Tournament(){
		//1. We add all the trainers to the contenders league
		cpuAna=new CpuAna();
		cpuJaime=new CpuJaime();
		cpuTony=new CpuTony();
		cpuJuan=new CpuJuan();
		cpuSimon=new CpuSimon();
		cpuJay=new CpuJay();
		cpuJoselu=new CpuJoselu();
		cpuMachine=new cpuMachine();
		
		//2. We add all the trainers to the contenders league
		contenders.add(cpuAna);
		contenders.add(cpuJaime);
		contenders.add(cpuTony);
		contenders.add(cpuJuan);
		contenders.add(cpuSimon);
		contenders.add(cpuJay);
		contenders.add(cpuJoselu);
		contenders.add(cpuMachine);
		
		
		//4. We execute the tournament
		executeTournament();
	}

	private void executeTournament() {
		//1. We calculate de number of phases
		if(contenders.size()/2!=0) {
			nPhases=(contenders.size()/2)-1;
		}else {
			nPhases=contenders.size()/2;
		}
		
		//2. We work on rounds
		do {
			round(contenders);
		}while(contenders.size()>1);
		
		//3. We throw the winner message
		presenter.showWinner(contenders.get(0));
	}

	private void round(List<Trainer> contenders) {
		int nCombats, rnd, rnd2;
		
		//1. We calculate the number of combats we are going to have in each phase/round
		nCombats=contenders.size()/2;
		
		for(int i=1; i<=nCombats; i++) {
			do {
				rnd=r.nextInt(contenders.size())+1;
				do {
					rnd2=r.nextInt(contenders.size())+1;
				}while (rnd==rnd2);
			}while(contenders.get(rnd).defeated==true || contenders.get(rnd2).defeated==true || contenders.get(rnd).winner==true || contenders.get(rnd2).winner==true);
	
			Combat combat = new Combat(contenders.get(rnd), contenders.get(rnd2));
			Keyboard.readInt("Continuar?");
		}
		
		for(int i=0; i<contenders.size();i++) {
			if(contenders.get(i).defeated==true) {
				contenders.remove(i);
			} else if(contenders.get(i).winner==true) {
				contenders.get(i).winner=false;
			}
		}
		
	}
	
	
}
