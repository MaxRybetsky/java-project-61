package hexlet.code.games;

import hexlet.code.validator.AnswerValidator;
import hexlet.code.Game;
import hexlet.code.random.RandomGenerator;

public class PrimeNumberGame implements Game {
    private static final String EVEN_GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private final String userName;

    public PrimeNumberGame(String userName) {
        this.userName = userName;
    }

    @Override
    public void printRules() {
        System.out.println(EVEN_GAME_RULES);
    }

    @Override
    public boolean playRound() {
        var givenNumber = getNumberForQuestion();
        var correctAnswer = calculateCorrectAnswer(givenNumber);

        return AnswerValidator.askAndValidateStringAnswer(
                String.valueOf(givenNumber),
                correctAnswer,
                userName
        );
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
