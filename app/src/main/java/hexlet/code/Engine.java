package hexlet.code;

import java.util.Objects;

import static hexlet.code.OptionsHandler.getOption;
import static hexlet.code.OptionsHandler.printOptions;
import static hexlet.code.io.InputScanner.readLine;
import static hexlet.code.io.Printer.printf;
import static hexlet.code.io.Printer.printfLn;
import static hexlet.code.io.Printer.println;
import static hexlet.code.validator.AnswerValidator.validate;

public class Engine {
    private static final String QUESTION_TEMPLATE = "Question: %s\nYour answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String WRONG_ANSWER_MESSAGE_TEMPLATE =
            "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!";
    private static final String CONGRATULATIONS_TEMPLATE = "Congratulations, %s!";

    private static final int NUMBER_OF_ROUNDS = 3;

    public static void startPlaying() {
        printOptions();
        var option = getOption();

        if (option.isExit()) {
            return;
        }

        var userName = Greeter.greetAndReturnUserName();
        var game = option.getGame();

        runGameForUser(game, userName);
    }

    private static void runGameForUser(Game game, String userName) {
        if (Objects.isNull(game)) {
            return;
        }

        var rightAnswersCount = 0;

        println(game.getRules());

        while (rightAnswersCount != NUMBER_OF_ROUNDS) {
            var roundData = game.initNewRound();

            askQuestion(roundData.getQuestion());
            var answer = readLine();

            var answerIsCorrect = validate(answer, roundData.getCorrectAnswer());

            if (answerIsCorrect) {
                println(CORRECT_ANSWER_MESSAGE);
                rightAnswersCount++;
            } else {
                printfLn(WRONG_ANSWER_MESSAGE_TEMPLATE, answer, roundData.getCorrectAnswer(), userName);
                return;
            }
        }

        printCongratulationsAfterPlaying(userName);
    }

    private static void askQuestion(String question) {
        printf(QUESTION_TEMPLATE, question);
    }

    private static void printCongratulationsAfterPlaying(String userName) {
        printfLn(CONGRATULATIONS_TEMPLATE, userName);
    }
}
