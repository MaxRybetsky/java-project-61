package hexlet.code.games;

import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;
import static hexlet.code.random.RandomGenerator.generateIntegerFromRange;

public final class PrimeNumberGame {
    private static final String PRIME_GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 150;

    private static final String YES = "yes";
    private static final String NO = "no";

    public static void play() {
        var rounds = new String[NUMBER_OF_ROUNDS][ROUND_CONTENT_NUMBER];

        for (var round : rounds) {
            var givenNumber = generateIntegerFromRange(MIN_VALUE, MAX_VALUE);
            var correctAnswer = calculateCorrectAnswer(givenNumber);

            round[0] = String.valueOf(givenNumber);
            round[1] = String.valueOf(correctAnswer);
        }

        runGame(getRules(), rounds);
    }

    private static String getRules() {
        return PRIME_GAME_RULES;
    }

    private static String calculateCorrectAnswer(int givenNumber) {
        return isPrime(givenNumber) ? YES : NO;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
