package hexlet.code.games;

import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.ROUND_CONTENT_NUMBER;
import static hexlet.code.Engine.runGame;
import static hexlet.code.random.RandomGenerator.generateIntegerFromRange;

public final class CalculatorGame {
    private static final String CALCULATOR_GAME_RULES = "What is the result of the expression?";

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 20;

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";

    private static final String[] OPERATIONS = {PLUS, MINUS, MULTIPLY};

    public static void play() {
        var rounds = new String[NUMBER_OF_ROUNDS][ROUND_CONTENT_NUMBER];

        for (var round : rounds) {
            var firstOperand = generateIntegerFromRange(MIN_VALUE, MAX_VALUE);
            var secondOperand = generateIntegerFromRange(MIN_VALUE, MAX_VALUE);
            var operation = getRandomOperation();

            var correctAnswer = calculateCorrectAnswer(operation, firstOperand, secondOperand);

            var question = buildStringExpression(firstOperand, operation, secondOperand);

            round[0] = question;
            round[1] = String.valueOf(correctAnswer);
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
        var indexOfOperation = generateIntegerFromRange(MIN_VALUE, OPERATIONS.length - 1);
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
            case MULTIPLY -> {
                return first * second;
            }
            default -> throw new RuntimeException("There is unknown operation: " + operation);
        }
    }
}
