package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.RandomGenerator;

import java.util.Scanner;

public class CalculatorGame implements Game {
    private static final String CALCULATOR_GAME_RULES = "What is the result of the expression?";

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";

    private static final String[] OPERATIONS = {PLUS, MINUS, MULTIPLY};

    private final String userName;

    public CalculatorGame(String userName) {
        this.userName = userName;
    }

    @Override
    public void printRules() {
        System.out.println(CALCULATOR_GAME_RULES);
    }

    @Override
    public boolean playRound() {
        var firstOperand = generateInt();
        var secondOperand = generateInt();
        var operation = getRandomOperation();

        var correctAnswer = calculateCorrectAnswer(operation, firstOperand, secondOperand);

        var question = buildStringExpression(firstOperand, operation, secondOperand);
        System.out.printf(QUESTION_TEMPLATE, question);

        var answer = getUserAnswer();

        if (correctAnswer == answer) {
            System.out.println(CORRECT_ANSWER_MESSAGE);
            return true;
        } else {
            System.out.printf(WRONG_ANSWER_MESSAGE_TEMPLATE, answer, correctAnswer, userName);
            return false;
        }
    }

    private String buildStringExpression(int first, String operation, int second) {
        return first + " " + operation + " " + second;
    }

    private String getRandomOperation() {
        var indexOfOperation = RandomGenerator.generateIntegerUpTo(OPERATIONS.length);
        return OPERATIONS[indexOfOperation];
    }

    private int calculateCorrectAnswer(String operation, int first, int second) {
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

    private int generateInt() {
        return RandomGenerator.generateInteger();
    }

    private int getUserAnswer() {
        var sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
