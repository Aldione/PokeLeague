package proyectoPokemon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Tournament {

//	private Presentador  presenter=new Presentador();

	public void executeTournament(List<Entrenador> contenders) {
		List<Entrenador> contendersList = new ArrayList<>();
		List<Entrenador> combatientes3Puesto = new ArrayList<>();
		
		contendersList.addAll(organizarCombatientes(contenders));
		
		esquemaTorneo(contendersList);
		
		//2. We work on rounds
		do {
			phase(contendersList);
			//Si se ha disputado la semifinal entonces se juega el tercer puesto
			if(contenders.size() == 4) {
				System.out.println("COMBATE POR EL TERCER PUESTO:");
				combatientes3Puesto.addAll(disputantesTercerPuesto(contendersList));
				
				combat(combatientes3Puesto);
				contendersList.removeAll(combatientes3Puesto);
			}
			contenders = borrarEliminados(contendersList);
		}while(contenders.size()>1);
		System.out.println("EL GANADOR ES: " + contendersList.get(0).getNombre());
	}

	private void phase(List<Entrenador> contenders) {

		List<Entrenador> combatientes = new ArrayList<>();
		
		//1. We calculate the number of combats we are going to have in each phase/round
		
		for(int i=0; i<contenders.size(); i++) {
			combatientes.add(contenders.get(i));
			if(combatientes.size() == 2) {
				combat(combatientes);
				combatientes.clear();
			}
		}
	}	

	private void combat(List<Entrenador> combatientes) {
		Combate combate = new Combate();
		
		//Se reinician los estados de los entrenadores y se borran sus pokemon
		borrarPokemon(combatientes.get(0));
		borrarPokemon(combatientes.get(1));
		
		combatientes.get(0).setGanador(false);
		combatientes.get(1).setGanador(false);
		
		combate.empezarCombate(combatientes.get(0), combatientes.get(1));
	}
	
	private List<Entrenador> borrarEliminados(List<Entrenador> listaEntrenadores) {
		List<Entrenador> listaCopia = new ArrayList<>();
		listaCopia.addAll(listaEntrenadores);
		
		for(Entrenador e : listaCopia) {
			if(e.isDerrotado()) {
			listaEntrenadores.remove(e);
			}
		}	
		return listaEntrenadores;
	}
	
	private void borrarPokemon(Entrenador entrenador) {
		entrenador.getListaPokemon().clear();
	}
	
	private Set<Entrenador> organizarCombatientes(List<Entrenador> contenders){
		Random random = new Random();
		Set<Entrenador> randomContenders = new HashSet<>();
		
		do {
			randomContenders.add(contenders.get(random.nextInt(contenders.size())));
		}while(randomContenders.size() < contenders.size());
		
		return randomContenders;	
	}
 	
	private List<Entrenador> disputantesTercerPuesto(List<Entrenador> contenders){
		List<Entrenador> combatientes = new ArrayList<>();
		
		for(int i=0; i<contenders.size(); i++) {
			if(contenders.get(i).isDerrotado()) {
				combatientes.add(contenders.get(i));
			}
		}
		
		for(int i=0; i<2; i++) {
			combatientes.get(i).setDerrotado(false);
			borrarPokemon(combatientes.get(i));
		}
		
		return combatientes;
	}
	
	private void esquemaTorneo(List<Entrenador> participantes) {
		System.out.printf(
				  "%-6S-----%n"
				+ "%-6S     |%n"
				+ "%-6S      ----- %-13S-----%n"
				+ "%-6S     |      %-13S     |%n"
				+ "%-6S-----       %-13S     |%n"
				+ "%-6S            %-13S      -----FINALISTA%n"
				+ "%-6S-----       %-13S     |%n"
				+ "%-6S     |      %-13S     |%n"
				+ "%-6S      ----- %-13S-----%n"
				+ "%-6S     |%n"
				+ "%-6S-----%n%n"
				
				+ "%-6S-----%n"
				+ "%-6S     |%n"
				+ "%-6S      ----- %-13S-----%n"
				+ "%-6S     |      %-13S     |%n"
				+ "%-6S-----       %-13S     |%n"
				+ "%-6S            %-13S      -----FINALISTA%n"
				+ "%-6S-----       %-13S     |%n"
				+ "%-6S     |      %-13S     |%n"
				+ "%-6S      ----- %-13S-----%n"
				+ "%-6S     |%n"
				+ "%-6S-----%n%n",
				participantes.get(0).getNombre(), "", "", "Semifinalista", "", "",
				participantes.get(1).getNombre(),"", "", "",
				
				participantes.get(2).getNombre(), "", "", "", "", "Semifinalista", "",
				participantes.get(3).getNombre(),
				
				participantes.get(4).getNombre(), "", "", "Semifinalista", "", "",
				participantes.get(5).getNombre(), "", "", "",
				
				participantes.get(6).getNombre(), "", "", "", "", "Semifinalista", "",
				participantes.get(7).getNombre());
	}
}