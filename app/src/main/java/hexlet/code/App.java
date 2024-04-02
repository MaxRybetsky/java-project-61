package hexlet.code;

import java.util.Scanner;

public class App {
    private static final String ENTER_GAME_NUMBER_MESSAGE = "Please enter the game number and press Enter.";
    private static final String CHOICE_MESSAGE = "Please enter the game number and press Enter.";

    private static final String[] OPTIONS = {
        "1 - Greet",
        "2 - Even",
        "0 - Exit"
    };

    public static void main(String[] args) {
        printOptions();

        var optionNumber = scanOptionNumber();

        doActionForChosenOption(optionNumber);
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

    private static void doActionForChosenOption(int optionNumber) {
        switch (optionNumber) {
            case 1 -> Cli.greetAndReturnUserName();
            case 2 -> EvenNumberGame.play();
            default -> exitFromGame();
        }
    }

    private static void exitFromGame() {
    }
}
