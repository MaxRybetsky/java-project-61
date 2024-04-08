package hexlet.code.options;

import hexlet.code.Game;
import hexlet.code.Option;

public final class ExitOption implements Option {
    private static final String OPTION_NAME = "Exit";

    @Override
    public Game getGame() {
        return null;
    }

    @Override
    public String getOptionName() {
        return OPTION_NAME;
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
