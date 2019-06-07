package pokemon;

public abstract class PokemonFactory {

	Database database= Database.INSTANCE;
	abstract Pokemon create();
}
