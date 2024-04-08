package hexlet.code.options;

import hexlet.code.Game;
import hexlet.code.Option;
import hexlet.code.games.EvenNumberGame;

public final class EvenOption implements Option {
    private static final String OPTION_NAME = "Even";

    @Override
    public Game getGame() {
        return new EvenNumberGame();
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
