package hexlet.code;

import java.util.Objects;

import static hexlet.code.Greeter.GREETING_MESSAGE_TEMPLATE;
import static hexlet.code.Greeter.NAME_QUESTION;
import static hexlet.code.Greeter.WELCOME_MESSAGE;
import static hexlet.code.io.InputScanner.readLine;
import static hexlet.code.io.Printer.print;
import static hexlet.code.io.Printer.printf;
import static hexlet.code.io.Printer.printfLn;
import static hexlet.code.io.Printer.println;

public class Engine {
    public static final int NUMBER_OF_ROUNDS = 3;
    public static final int NUMBER_OF_ROUND_CONTENT = 2;

    private static final String QUESTION_TEMPLATE = "Question: %s\nYour answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String WRONG_ANSWER_MESSAGE_TEMPLATE =
            "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!";
    private static final String CONGRATULATIONS_TEMPLATE = "Congratulations, %s!";

    public static void runGame(String rules, String[][] rounds) {
        println(WELCOME_MESSAGE);
        print(NAME_QUESTION);

        var userName = readLine();

        printfLn(GREETING_MESSAGE_TEMPLATE, userName);
        println(rules);

        for (var round : rounds) {
            var question = round[0];
            var correctAnswer = round[1];

            printf(QUESTION_TEMPLATE, question);

            var userAnswer = readLine();
            if (Objects.equals(userAnswer, correctAnswer)) {
                println(CORRECT_ANSWER_MESSAGE);
            } else {
                printfLn(WRONG_ANSWER_MESSAGE_TEMPLATE, userAnswer, correctAnswer, userName);
                return;
            }
        }

        printfLn(CONGRATULATIONS_TEMPLATE, userName);
    }
}
