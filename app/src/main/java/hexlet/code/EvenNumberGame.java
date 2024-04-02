package hexlet.code;

import java.util.Scanner;

public class EvenNumberGame {
    private static final String EVEN_GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String YES = "yes";
    private static final String NO = "no";

    private static final String QUESTION_TEMPLATE = "Question: %d\nYour answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String WRONG_ANSWER_MESSAGE_TEMPLATE =
            "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!\n";

    private static final String CONGRATULATIONS_TEMPLATE = "Congratulations, %s!\n";

    public static void play() {
        var userName = Cli.greetAndReturnUserName();

        printRules();
        runEvenGame(userName);
        printCongratulationsAfterPlaying(userName);
    }

    private static void runEvenGame(String userName) {
        var rightAnswersCount = 0;

        while (rightAnswersCount != 3) {
            var givenNumber = getNumberForQuestion();
            var correctAnswer = calculateCorrectAnswer(givenNumber);

            System.out.printf(QUESTION_TEMPLATE, givenNumber);

            var answer = getUserAnswer();

            if (correctAnswer.equals(answer)) {
                System.out.println(CORRECT_ANSWER_MESSAGE);
                rightAnswersCount++;
            } else {
                System.out.printf(WRONG_ANSWER_MESSAGE_TEMPLATE, answer, correctAnswer, userName);
                rightAnswersCount = 0;
            }
        }
    }

    private static String getUserAnswer() {
        var sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static String calculateCorrectAnswer(int givenNumber) {
        return givenNumber % 2 == 0 ? YES : NO;
    }

    private static int getNumberForQuestion() {
        return (int) (Math.random() * 100);
    }

    private static void printRules() {
        System.out.println(EVEN_GAME_RULES);
    }

    private static void printCongratulationsAfterPlaying(String userName) {
        System.out.printf(CONGRATULATIONS_TEMPLATE, userName);
    }
}
