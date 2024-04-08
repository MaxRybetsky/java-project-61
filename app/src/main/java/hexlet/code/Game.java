package hexlet.code;

import hexlet.code.data.GameRoundData;

public interface Game {
    String YES = "yes";
    String NO = "no";

    String getRules();
    GameRoundData initNewRound();
}
