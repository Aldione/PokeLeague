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
import pokemon.Died;


public class CPUJuan {

	String requestName() {
		return "Juan a.k.a. The businessman";
	}
	
	public int elegirOpcionCombate() {
		return 1;
	}
	
	public void elegirSiguienteMovimiento(Pokemon pokemon, Pokemon pokemonRival) {
		int rnd = r.nextInt(4-1) + 1;
		
		return rnd;
	}
	
	public void cambiarPokemon(Pokemon pokemonx) {
		int rnd;
		
		do {
			rnd = r.nextInt(3);
		}while(this.pokeTeam.get(rnd).getStatus() instanceof Died);
		
		return rnd;
	}
}
