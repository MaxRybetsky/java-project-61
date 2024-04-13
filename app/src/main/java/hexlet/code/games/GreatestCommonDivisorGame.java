package hexlet.code.games;

import hexlet.code.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_ARRAY_SIZE;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;

public final class GreatestCommonDivisorGame {
    private static final String GCD_GAME_RULES = "Find the greatest common divisor of given numbers.";

    public static void play() {
        var rounds = new String[ROUNDS_ARRAY_SIZE];

        for (int i = 0; i < rounds.length; i += ROUND_CONTENT_NUMBER) {
            var firstNumber = generateInt();
            var secondNumber = generateInt();

            var correctAnswer = calculateGcdOf(firstNumber, secondNumber);
            var question = buildStringQuestion(firstNumber, secondNumber);

            rounds[i] = question;
            rounds[i + 1] = String.valueOf(correctAnswer);
        }

        runGame(getRules(), rounds);
    }

    private static String getRules() {
        return GCD_GAME_RULES;
    }

    private static int calculateGcdOf(int firstNumber, int secondNumber) {
        var maxNumber = Math.max(firstNumber, secondNumber);
        var minNumber = Math.min(firstNumber, secondNumber);

        var result = minNumber;

        while (maxNumber % minNumber != 0) {
            result = maxNumber % minNumber;
            maxNumber = minNumber;
            minNumber = result;
        }

        return result;
    }

    private static String buildStringQuestion(int first, int second) {
        return first + " " + second;
    }

    private static int generateInt() {
        return RandomGenerator.generateInteger();
    }
}
