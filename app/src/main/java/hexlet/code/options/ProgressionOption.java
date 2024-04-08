package hexlet.code.options;

import hexlet.code.Game;
import hexlet.code.Option;
import hexlet.code.games.ArithmeticProgressionGame;

public final class ProgressionOption implements Option {
    private static final String OPTION_NAME = "Progression";

    @Override
    public Game getGame() {
        return new ArithmeticProgressionGame();
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
