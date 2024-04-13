package hexlet.code.games;

import hexlet.code.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_ARRAY_SIZE;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;

public final class ArithmeticProgressionGame {
    private static final String ARITHMETIC_PROGRESSION_GAME_RULES = "What number is missing in the progression?";

    private static final int DEFAULT_BOUND_VALUE = 20;
    private static final int PROGRESSION_LENGTH = 10;

    public static void play() {
        var rounds = new String[ROUNDS_ARRAY_SIZE];

        for (int i = 0; i < rounds.length; i += ROUND_CONTENT_NUMBER) {
            var progressionElements = generateProgression();

            var indexForQuestion = generateInt(PROGRESSION_LENGTH);
            var correctAnswer = progressionElements[indexForQuestion];
            var question = buildStringQuestion(progressionElements, indexForQuestion);

            rounds[i] = question;
            rounds[i + 1] = String.valueOf(correctAnswer);
        }

        runGame(getRules(), rounds);
    }

    private static String getRules() {
        return ARITHMETIC_PROGRESSION_GAME_RULES;
    }


    private static int[] generateProgression() {
        var firstElement = generateInt(DEFAULT_BOUND_VALUE);
        var delta = generateInt(DEFAULT_BOUND_VALUE);

        var progression = new int[PROGRESSION_LENGTH];
        progression[0] = firstElement;

        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            progression[i] = progression[i - 1] + delta;
        }

        return progression;
    }

    private static String buildStringQuestion(int[] progression, int indexQuestion) {
        var stringBuilder = new StringBuilder();

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            if (i == indexQuestion) {
                stringBuilder.append("..");
            } else {
                stringBuilder.append(progression[i]);
            }

            if (i != PROGRESSION_LENGTH - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    private static int generateInt(int bound) {
        return RandomGenerator.generateIntegerUpTo(bound);
    }
}
