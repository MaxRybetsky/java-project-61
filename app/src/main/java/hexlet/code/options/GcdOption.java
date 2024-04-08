package hexlet.code.options;

import hexlet.code.Game;
import hexlet.code.Option;
import hexlet.code.games.GreatestCommonDivisorGame;

public final class GcdOption implements Option {
    private static final String OPTION_NAME = "GCD";

    @Override
    public Game getGame() {
        return new GreatestCommonDivisorGame();
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
