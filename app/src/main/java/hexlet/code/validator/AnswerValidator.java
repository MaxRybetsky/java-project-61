package hexlet.code.validator;

import java.util.Objects;
import java.util.Scanner;

import static hexlet.code.Game.CORRECT_ANSWER_MESSAGE;
import static hexlet.code.Game.QUESTION_TEMPLATE;
import static hexlet.code.Game.WRONG_ANSWER_MESSAGE_TEMPLATE;


public class AnswerValidator {
    public static boolean askAndValidateIntegerAnswer(String question, int correctAnswer, String userName) {
        askQuestion(question);

        var answer = getUserIntegerAnswer();

        if (correctAnswer == answer) {
            System.out.println(CORRECT_ANSWER_MESSAGE);
            return true;
        } else {
            System.out.printf(WRONG_ANSWER_MESSAGE_TEMPLATE, answer, correctAnswer, userName);
            return false;
        }
    }

    public static boolean askAndValidateStringAnswer(String question, String correctAnswer, String userName) {
        askQuestion(question);

        var answer = getUserStringAnswer();

        if (Objects.equals(answer, correctAnswer)) {
            System.out.println(CORRECT_ANSWER_MESSAGE);
            return true;
        } else {
            System.out.printf(WRONG_ANSWER_MESSAGE_TEMPLATE, answer, correctAnswer, userName);
            return false;
        }
    }

    private static void askQuestion(String question) {
        System.out.printf(QUESTION_TEMPLATE, question);
    }

    private static int getUserIntegerAnswer() {
        var sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static String getUserStringAnswer() {
        var sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
