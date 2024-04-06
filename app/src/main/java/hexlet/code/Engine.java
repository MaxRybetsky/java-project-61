package hexlet.code;

import hexlet.code.games.ArithmeticProgressionGame;
import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenNumberGame;
import hexlet.code.games.GreatestCommonDivisorGame;
import hexlet.code.games.PrimeNumberGame;

import java.util.Objects;
import java.util.Scanner;

public class Engine {
    private static final String ENTER_GAME_NUMBER_MESSAGE = "Please enter the game number and press Enter.";
    private static final String CHOICE_MESSAGE = "Please enter the game number and press Enter.";
    private static final String CONGRATULATIONS_TEMPLATE = "Congratulations, %s!\n";

    private static final int NUMBER_OF_ROUNDS = 3;

    private static final String[] OPTIONS = {
        "1 - Greet",
        "2 - Even",
        "3 - Calc",
        "4 - GCD",
        "5 - Progression",
        "6 - Prime",
        "0 - Exit"
    };

    public static void startPlaying() {
        printOptions();

        var optionNumber = scanOptionNumber();

        if (optionNumber == 0) {
            return;
        }

        var userName = Cli.greetAndReturnUserName();

        var game = getGameForUserByOption(userName, optionNumber);

        if (gameWasNotChosen(game)) {
            return;
        }

        runGame(game);

        printCongratulationsAfterPlaying(userName);
    }

    private static void runGame(Game game) {
        game.printRules();

        var rightAnswersCount = 0;

        while (rightAnswersCount != NUMBER_OF_ROUNDS) {
            var roundResult = game.playRound();

            if (roundResult) {
                rightAnswersCount++;
            } else {
                rightAnswersCount = 0;
            }
        }
    }

    private static boolean gameWasNotChosen(Game game) {
        return Objects.isNull(game);
    }

    private static void printOptions() {
        System.out.println(ENTER_GAME_NUMBER_MESSAGE);

        for (var option : OPTIONS) {
            System.out.println(option);
        }

        System.out.println(CHOICE_MESSAGE);
    }

    private static int scanOptionNumber() {
        var scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    private static Game getGameForUserByOption(String userName, int optionNumber) {
        switch (optionNumber) {
            case 2 -> {
                return new EvenNumberGame(userName);
            }
            case 3 -> {
                return new CalculatorGame(userName);
            }
            case 4 -> {
                return new GreatestCommonDivisorGame(userName);
            }
            case 5 -> {
                return new ArithmeticProgressionGame(userName);
            }
            case 6 -> {
                return new PrimeNumberGame(userName);
            }
            default -> {
                return null;
            }
        }
    }

    private static void printCongratulationsAfterPlaying(String userName) {
        System.out.printf(CONGRATULATIONS_TEMPLATE, userName);
    }
}
