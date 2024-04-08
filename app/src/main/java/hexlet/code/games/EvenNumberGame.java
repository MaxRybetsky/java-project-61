package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.data.GameRoundData;
import hexlet.code.random.RandomGenerator;

public final class EvenNumberGame implements Game {
    private static final String EVEN_GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    @Override
    public String getRules() {
        return EVEN_GAME_RULES;
    }

    @Override
    public GameRoundData initNewRound() {
        var givenNumber = getNumberForQuestion();
        var correctAnswer = calculateCorrectAnswer(givenNumber);

        return new GameRoundData(givenNumber, correctAnswer);
    }

    private String calculateCorrectAnswer(int givenNumber) {
        return givenNumber % 2 == 0 ? YES : NO;
    }

    private int getNumberForQuestion() {
        return RandomGenerator.generateInteger();
    }
}
