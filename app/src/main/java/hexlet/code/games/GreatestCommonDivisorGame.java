package hexlet.code.games;

import hexlet.code.validator.AnswerValidator;
import hexlet.code.Game;
import hexlet.code.random.RandomGenerator;

public class GreatestCommonDivisorGame implements Game {
    private static final String GCD_GAME_RULES = "Find the greatest common divisor of given numbers.";

    private final String userName;

    public GreatestCommonDivisorGame(String userName) {
        this.userName = userName;
    }

    @Override
    public void printRules() {
        System.out.println(GCD_GAME_RULES);
    }

    @Override
    public boolean playRound() {
        var firstNumber = generateInt();
        var secondNumber = generateInt();

        var correctAnswer = calculateGcdOf(firstNumber, secondNumber);

        var question = buildStringQuestion(firstNumber, secondNumber);

        return AnswerValidator.askAndValidateIntegerAnswer(question, correctAnswer, userName);
    }

    private int calculateGcdOf(int firstNumber, int secondNumber) {
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

    private String buildStringQuestion(int first, int second) {
        return first + " " + second;
    }

    private int generateInt() {
        return RandomGenerator.generateInteger();
    }
}
