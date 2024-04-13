package hexlet.code.games;

import hexlet.code.random.RandomGenerator;

import static hexlet.code.Engine.ROUND_ARRAY_SIZE;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;

public final class CalculatorGame {
    private static final String CALCULATOR_GAME_RULES = "What is the result of the expression?";

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";

    private static final String[] OPERATIONS = {PLUS, MINUS, MULTIPLY};

    public static void play() {
        var rounds = new String[ROUND_ARRAY_SIZE];

        for (int i = 0; i < rounds.length; i += ROUND_CONTENT_NUMBER) {
            var firstOperand = generateInt();
            var secondOperand = generateInt();
            var operation = getRandomOperation();

            var correctAnswer = calculateCorrectAnswer(operation, firstOperand, secondOperand);

            var question = buildStringExpression(firstOperand, operation, secondOperand);

            rounds[i] = question;
            rounds[i + 1] = String.valueOf(correctAnswer);
        }

        runGame(getRules(), rounds);
    }

    private static String getRules() {
        return CALCULATOR_GAME_RULES;
    }


    private static String buildStringExpression(int first, String operation, int second) {
        return first + " " + operation + " " + second;
    }

    private static String getRandomOperation() {
        var indexOfOperation = RandomGenerator.generateIntegerUpTo(OPERATIONS.length);
        return OPERATIONS[indexOfOperation];
    }

    private static int calculateCorrectAnswer(String operation, int first, int second) {
        switch (operation) {
            case PLUS -> {
                return first + second;
            }
            case MINUS -> {
                return first - second;
            }
            default -> {
                return first * second;
            }
        }
    }

    private static int generateInt() {
        return RandomGenerator.generateInteger();
    }
}
