package hexlet.code.games;

import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;
import static hexlet.code.random.RandomGenerator.generateIntegerFromRange;

public final class EvenNumberGame {
    private static final String EVEN_GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 1000;

    private static final String YES = "yes";
    private static final String NO = "no";

    public static void play() {
        var rounds = new String[NUMBER_OF_ROUNDS][ROUND_CONTENT_NUMBER];

        for (var round : rounds) {
            var givenNumber = generateIntegerFromRange(MIN_VALUE, MAX_VALUE);
            var correctAnswer = calculateCorrectAnswer(givenNumber);

            round[0] = String.valueOf(givenNumber);
            round[1] = correctAnswer;
        }

        runGame(getRules(), rounds);
    }

    private static String getRules() {
        return EVEN_GAME_RULES;
    }

    private static String calculateCorrectAnswer(int givenNumber) {
        return givenNumber % 2 == 0 ? YES : NO;
    }
}
