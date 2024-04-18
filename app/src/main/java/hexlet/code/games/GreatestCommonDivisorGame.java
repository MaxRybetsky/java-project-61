package hexlet.code.games;

import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;
import static hexlet.code.random.RandomGenerator.generateIntegerFromRange;

public final class GreatestCommonDivisorGame {
    private static final String GCD_GAME_RULES = "Find the greatest common divisor of given numbers.";

    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 99;

    public static void play() {
        var rounds = new String[NUMBER_OF_ROUNDS][ROUND_CONTENT_NUMBER];

        for (var round : rounds) {
            var firstNumber = generateIntegerFromRange(MIN_VALUE, MAX_VALUE);
            var secondNumber = generateIntegerFromRange(MIN_VALUE, MAX_VALUE);

            var correctAnswer = calculateGcdOf(firstNumber, secondNumber);
            var question = buildStringQuestion(firstNumber, secondNumber);

            round[0] = question;
            round[1] = String.valueOf(correctAnswer);
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
}
