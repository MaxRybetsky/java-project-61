package hexlet.code.games;

import hexlet.code.random.RandomGenerator;

import static hexlet.code.Engine.ROUND_ARRAY_SIZE;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;

public final class EvenNumberGame {
    private static final String EVEN_GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final String YES = "yes";
    private static final String NO = "no";

    public static void play() {
        var rounds = new String[ROUND_ARRAY_SIZE];

        for (int i = 0; i < rounds.length; i += ROUND_CONTENT_NUMBER) {
            var givenNumber = getNumberForQuestion();
            var correctAnswer = calculateCorrectAnswer(givenNumber);

            rounds[i] = String.valueOf(givenNumber);
            rounds[i + 1] = correctAnswer;
        }

        runGame(getRules(), rounds);
    }

    private static String getRules() {
        return EVEN_GAME_RULES;
    }

    private static String calculateCorrectAnswer(int givenNumber) {
        return givenNumber % 2 == 0 ? YES : NO;
    }

    private static int getNumberForQuestion() {
        return RandomGenerator.generateInteger();
    }
}
