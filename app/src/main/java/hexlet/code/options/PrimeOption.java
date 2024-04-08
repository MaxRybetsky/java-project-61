package hexlet.code.options;

import hexlet.code.Game;
import hexlet.code.Option;
import hexlet.code.games.PrimeNumberGame;

public final class PrimeOption implements Option {
    private static final String OPTION_NAME = "Prime";

    @Override
    public Game getGame() {
        return new PrimeNumberGame();
    }

    @Override
    public String getOptionName() {
        return OPTION_NAME;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
