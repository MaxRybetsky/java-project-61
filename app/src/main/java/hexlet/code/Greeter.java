package hexlet.code;

import static hexlet.code.io.InputScanner.readLine;
import static hexlet.code.io.Printer.print;
import static hexlet.code.io.Printer.printfLn;
import static hexlet.code.io.Printer.println;

public class Greeter {
    public static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    public static final String NAME_QUESTION = "May I have your name? ";
    public static final String GREETING_MESSAGE_TEMPLATE = "\nHello, %s!\n";

    public static void greet() {
        printGreeting();

        askName();
        var userName = readLine();

        sayHelloWithName(userName);
    }

    private static void printGreeting() {
        println(WELCOME_MESSAGE);
    }

    private static void askName() {
        print(NAME_QUESTION);
    }

    private static void sayHelloWithName(String userName) {
        printfLn(GREETING_MESSAGE_TEMPLATE, userName);
    }
}
