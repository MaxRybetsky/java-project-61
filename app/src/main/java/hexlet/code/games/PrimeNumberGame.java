package hexlet.code.games;

import hexlet.code.data.GameRoundData;
import hexlet.code.Game;
import hexlet.code.random.RandomGenerator;

public final class PrimeNumberGame implements Game {
    private static final String PRIME_GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    @Override
    public String getRules() {
        return PRIME_GAME_RULES;
    }

    @Override
    public GameRoundData initNewRound() {
        var givenNumber = getNumberForQuestion();
        var correctAnswer = calculateCorrectAnswer(givenNumber);

        return new GameRoundData(givenNumber, correctAnswer);
    }

    private String calculateCorrectAnswer(int givenNumber) {
        return isPrime(givenNumber) ? YES : NO;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int getNumberForQuestion() {
        return RandomGenerator.generateInteger() + 2;
    }
}
