package hexlet.code.options;

import hexlet.code.Game;
import hexlet.code.Option;
import hexlet.code.games.CalculatorGame;

public final class CalculatorOption implements Option {
    private static final String OPTION_NAME = "Calc";

    @Override
    public Game getGame() {
        return new CalculatorGame();
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
