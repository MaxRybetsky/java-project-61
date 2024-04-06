package hexlet.code.games;

import hexlet.code.validator.AnswerValidator;
import hexlet.code.Game;
import hexlet.code.random.RandomGenerator;

public class ArithmeticProgressionGame implements Game {
    private static final String ARITHMETIC_PROGRESSION_GAME_RULES = "What number is missing in the progression?";

    private static final int DEFAULT_BOUND_VALUE = 20;
    private static final int PROGRESSION_LENGTH = 10;

    private final String userName;

    public ArithmeticProgressionGame(String userName) {
        this.userName = userName;
    }

    @Override
    public void printRules() {
        System.out.println(ARITHMETIC_PROGRESSION_GAME_RULES);
    }

    @Override
    public boolean playRound() {
        var firstElement = generateInt(DEFAULT_BOUND_VALUE);
        var delta = generateInt(DEFAULT_BOUND_VALUE);

        var progressionElements = generateProgression(firstElement, delta);

        var indexForQuestion = generateInt(PROGRESSION_LENGTH);
        var correctAnswer = progressionElements[indexForQuestion];
        var question = buildStringQuestion(progressionElements, indexForQuestion);

        return AnswerValidator.askAndValidateIntegerAnswer(question, correctAnswer, userName);
    }

    private int[] generateProgression(int firstElement, int delta) {
        var progression = new int[PROGRESSION_LENGTH];
        progression[0] = firstElement;

        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            progression[i] = progression[i - 1] + delta;
        }

        return progression;
    }

    private String buildStringQuestion(int[] progression, int indexQuestion) {
        var stringBuilder = new StringBuilder();

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            if (i == indexQuestion) {
                stringBuilder.append("..");
            } else {
                stringBuilder.append(progression[i]);
            }

            if (i != PROGRESSION_LENGTH - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    private int generateInt(int bound) {
        return RandomGenerator.generateIntegerUpTo(bound);
    }
}