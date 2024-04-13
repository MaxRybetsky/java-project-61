package hexlet.code;

import static hexlet.code.Greeter.GREETING_MESSAGE_TEMPLATE;
import static hexlet.code.Greeter.NAME_QUESTION;
import static hexlet.code.Greeter.WELCOME_MESSAGE;
import static hexlet.code.io.InputScanner.readLine;
import static hexlet.code.io.Printer.print;
import static hexlet.code.io.Printer.printf;
import static hexlet.code.io.Printer.printfLn;
import static hexlet.code.io.Printer.println;
import static hexlet.code.validator.AnswerValidator.answerIsNotValid;

public class Engine {
    public static final int NUMBER_OF_ROUNDS = 3;
    public static final int ROUND_CONTENT_NUMBER = 2;
    public static final int ROUND_ARRAY_SIZE = NUMBER_OF_ROUNDS * ROUND_CONTENT_NUMBER;

    private static final String QUESTION_TEMPLATE = "Question: %s\nYour answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String WRONG_ANSWER_MESSAGE_TEMPLATE =
            "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!";
    private static final String CONGRATULATIONS_TEMPLATE = "Congratulations, %s!";

    public static void runGame(String rules, String[] rounds) {
        var userName = greetAndReturnUserName();
        println(rules);

        for (int i = 0; i < rounds.length; i += ROUND_CONTENT_NUMBER) {
            var question = rounds[i];
            var correctAnswer = rounds[i + 1];

            printf(QUESTION_TEMPLATE, question);

            var userAnswer = readLine();
            if (answerIsNotValid(userAnswer, correctAnswer)) {
                printfLn(WRONG_ANSWER_MESSAGE_TEMPLATE, userAnswer, correctAnswer, userName);
                return;
            } else {
                println(CORRECT_ANSWER_MESSAGE);
            }
        }

        printfLn(CONGRATULATIONS_TEMPLATE, userName);
    }

    private static String greetAndReturnUserName() {
        println(WELCOME_MESSAGE);
        print(NAME_QUESTION);

        var userName = readLine();

        printfLn(GREETING_MESSAGE_TEMPLATE, userName);

        return userName;
    }
}
