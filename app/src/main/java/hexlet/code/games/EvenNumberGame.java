package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.RandomGenerator;

import java.util.Scanner;

public class EvenNumberGame implements Game {
    private static final String EVEN_GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String YES = "yes";
    private static final String NO = "no";

    private final String userName;

    public EvenNumberGame(String userName) {
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

        System.out.printf(QUESTION_TEMPLATE, givenNumber);

        var answer = getUserAnswer();

        if (correctAnswer.equals(answer)) {
            System.out.println(CORRECT_ANSWER_MESSAGE);
            return true;
        } else {
            System.out.printf(WRONG_ANSWER_MESSAGE_TEMPLATE, answer, correctAnswer, userName);
            return false;
        }
    }

    private String getUserAnswer() {
        var sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private String calculateCorrectAnswer(int givenNumber) {
        return givenNumber % 2 == 0 ? YES : NO;
    }

    private int getNumberForQuestion() {
        return RandomGenerator.generateInteger();
    }
}
