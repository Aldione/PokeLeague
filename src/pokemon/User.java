package pokemon;

public class User extends Trainer implements UserPresenter{

	@Override
	public String requestName() {
		return presenter.requestName();
	}

	@Override
	public int requestOption() {
		return presenter.requestOption();
	}

	@Override
	public int requestAttack(Pokemon pokemon) {
		return presenter.requestAttack(pokemon);
	}

	@Override
	public int requestPokemon() {
		return presenter.requestPokemon(this);
	}

}
