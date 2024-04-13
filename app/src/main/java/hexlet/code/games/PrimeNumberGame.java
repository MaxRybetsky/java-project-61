package hexlet.code.games;

import hexlet.code.random.RandomGenerator;

import static hexlet.code.Engine.ROUND_ARRAY_SIZE;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;

public final class PrimeNumberGame {
    private static final String PRIME_GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final String YES = "yes";
    private static final String NO = "no";

    public static void play() {
        var rounds = new String[ROUND_ARRAY_SIZE];

        for (int i = 0; i < rounds.length; i += ROUND_CONTENT_NUMBER) {
            var givenNumber = getNumberForQuestion();
            var correctAnswer = calculateCorrectAnswer(givenNumber);

            rounds[i] = String.valueOf(givenNumber);
            rounds[i + 1] = String.valueOf(correctAnswer);
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
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static int getNumberForQuestion() {
        return RandomGenerator.generateInteger() + 2;
    }
}
