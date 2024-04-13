package hexlet.code;

import hexlet.code.games.EvenNumberGame;
import hexlet.code.games.CalculatorGame;
import hexlet.code.games.GreatestCommonDivisorGame;
import hexlet.code.games.ArithmeticProgressionGame;
import hexlet.code.games.PrimeNumberGame;

import static hexlet.code.io.InputScanner.readLine;
import static hexlet.code.io.Printer.print;
import static hexlet.code.io.Printer.println;

public class App {
    private static final String YOUR_CHOICE_MESSAGE = "Your choice: ";

    private static final String[] OPTIONS = {
        "1 - Greet",
        "2 - Even",
        "3 - Calc",
        "4 - GCD",
        "5 - Progression",
        "6 - Prime",
        "0 - Exit"
    };

    public static void main(String[] args) {
        for (var option : OPTIONS) {
            println(option);
        }
        print(YOUR_CHOICE_MESSAGE);

        var choice = readLine();
        chooseActionDueChoice(choice);
    }

    private static void chooseActionDueChoice(String choice) {
        switch (choice) {
            case "1" -> Greeter.greet();
            case "2" -> EvenNumberGame.play();
            case "3" -> CalculatorGame.play();
            case "4" -> GreatestCommonDivisorGame.play();
            case "5" -> ArithmeticProgressionGame.play();
            case "6" -> PrimeNumberGame.play();
            default -> { }
        }
    }
}
