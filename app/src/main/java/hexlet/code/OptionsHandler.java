package hexlet.code;

import hexlet.code.options.CalculatorOption;
import hexlet.code.options.EvenOption;
import hexlet.code.options.ExitOption;
import hexlet.code.options.GcdOption;
import hexlet.code.options.GreetingOption;
import hexlet.code.options.PrimeOption;
import hexlet.code.options.ProgressionOption;

import static hexlet.code.io.InputScanner.readLine;
import static hexlet.code.io.Printer.print;
import static hexlet.code.io.Printer.println;

public class OptionsHandler {
    private static final String ENTER_GAME_NUMBER_MESSAGE = "Please enter the game number and press Enter.";
    private static final String CHOICE_MESSAGE = "Your choice: ";

    private static final String DELIMITER = " - ";

    private static final Option[] OPTIONS = {
            new ExitOption(),
            new GreetingOption(),
            new EvenOption(),
            new CalculatorOption(),
            new GcdOption(),
            new ProgressionOption(),
            new PrimeOption(),
    };

    public static void printOptions() {
        println(ENTER_GAME_NUMBER_MESSAGE);

        for (int i = 1; i <= OPTIONS.length; i++) {
            if (i == OPTIONS.length) {
                var firstIndexOfExit = 0;
                println(firstIndexOfExit + DELIMITER + OPTIONS[firstIndexOfExit].getOptionName());
            } else {
                println(i + DELIMITER + OPTIONS[i].getOptionName());
            }
        }

        print(CHOICE_MESSAGE);
    }

    public static Option getOption() {
        var inputIndexOfOption = scanChosenOptionNumber();

        if (inputIndexOfOption < 0 || inputIndexOfOption >= OPTIONS.length) {
            return OPTIONS[0];
        } else {
            return OPTIONS[inputIndexOfOption];
        }
    }

    private static int scanChosenOptionNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            return 0;
        }
    }
}
