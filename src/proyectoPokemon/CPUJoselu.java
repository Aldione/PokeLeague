package proyectoPokemon;


import java.util.IntSummaryStatistics;
import java.util.Random;

import categoria.EstadoDor;
import categoria.EstadoEnv;
import categoria.EstadoPar;
import estados.Debilitado;
import estados.Dormido;
import estados.Envenenado;
import estados.Paralizado;
import estados.Sano;




public class CPUJoselu extends Entrenador{

	private Random rnd = new Random();
	


	String requestName() {
		return "Joselu";
	}


	public int elegirOpcionCombate() {
//        int conteoPokemonMuertosEnt = (int) this.getListaPokemon().stream()
//                                                 .filter(pok -> pok.getVida() >= 0)
//                                                 .count();
//        if(conteoPokemonMuertosEnt == 1) {
//            return 1;
//        }
//        else {
//            return rnd.nextInt(2)+1;
//        }
		return 1;
    }

	@Override
	public void elegirSiguienteMovimiento(Pokemon pokemon, Pokemon pokemonRival) {
		//Plantear logica del ataque para la IA.
				int chooseAttack = 0;
				boolean realiceAttack = false;
				IntSummaryStatistics powerMax = pokemon.getEspecie().getMovimientos().stream()
												   				  			       .mapToInt(attack -> attack.getPotencia())
												   				                   .summaryStatistics();
//				Primero comprobamos que el pokemon receptor del ataque no este en sano, porque si no tiene el estado sano, le aplicamos un 
//				ataque Fisico/Especial con mas potencia.
				if(!(pokemonRival.getEstado() instanceof Sano)) {
//					Recorremos en busca del ataque con mas poder de ataque, para realizarlo.
					for(int i = 0; i < pokemon.getEspecie().getMovimientos().size(); i++) {
						if(pokemon.getEspecie().getMovimientos().get(i).getPotencia() == powerMax.getMax()) {
							chooseAttack = i;
						}
					}
//				De lo contrario, le realizamos un ataque de estado.
				}else {
//					Y sino vamos realizando un ataque de estado con cierta prioridad uno de otro.
					for(int x = 0; x < pokemon.getEspecie().getMovimientos().size(); x++) {
						if(pokemon.getEspecie().getMovimientos().get(x).getCategoria() instanceof EstadoDor && realiceAttack == false) {
							chooseAttack = x;
							realiceAttack = true;
						}else if(pokemon.getEspecie().getMovimientos().get(x).getCategoria() instanceof EstadoPar && realiceAttack == false) {
							chooseAttack = x;
							realiceAttack = true;
						}else if(pokemon.getEspecie().getMovimientos().get(x).getCategoria() instanceof EstadoEnv && realiceAttack == false){
							chooseAttack = x;
							realiceAttack = true;
						}
					}
				}
		pokemon.setProximoMovimiento(pokemon.getEspecie().getMovimientos().get(chooseAttack));
	}

	@Override
	public void cambiarPokemon(Pokemon pokemonx) {
		int pokemon;
		do {
			pokemon = rnd.nextInt(3);
		}while(getListaPokemon().get(pokemon).getEstado() instanceof Debilitado);
		
		setPokemonCombatiente(getListaPokemon().get(pokemon));
	}

}