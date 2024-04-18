package hexlet.code.games;

import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROUND_CONTENT;
import static hexlet.code.Engine.runGame;
import static hexlet.code.random.RandomGenerator.generateIntegerFromRange;

public final class ArithmeticProgressionGame {
    private static final String ARITHMETIC_PROGRESSION_GAME_RULES = "What number is missing in the progression?";

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    private static final int PROGRESSION_LENGTH = 10;

    public static void play() {
        var rounds = new String[NUMBER_OF_ROUNDS][NUMBER_OF_ROUND_CONTENT];

        for (var round : rounds) {
            var firstElement = generateIntegerFromRange(MIN_VALUE, MAX_VALUE);
            var delta = generateIntegerFromRange(MIN_VALUE, MAX_VALUE);

            var progressionElements = generateProgression(firstElement, delta, PROGRESSION_LENGTH);

            var indexForQuestion = generateIntegerFromRange(MIN_VALUE, PROGRESSION_LENGTH);
            var correctAnswer = progressionElements[indexForQuestion];
            var question = buildStringQuestion(progressionElements, indexForQuestion);

            round[0] = question;
            round[1] = String.valueOf(correctAnswer);
        }

        runGame(getRules(), rounds);
    }

    private static String getRules() {
        return ARITHMETIC_PROGRESSION_GAME_RULES;
    }

    private static int[] generateProgression(int firstElement, int delta, int length) {
        var progression = new int[length];
        progression[0] = firstElement;

        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + delta;
        }

        return progression;
    }

    private static String buildStringQuestion(int[] progression, int indexQuestion) {
        var stringBuilder = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == indexQuestion) {
                stringBuilder.append("..");
            } else {
                stringBuilder.append(progression[i]);
            }

            if (i != progression.length - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
