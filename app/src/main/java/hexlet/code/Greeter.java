package hexlet.code;

import static hexlet.code.io.InputScanner.readLine;
import static hexlet.code.io.Printer.print;
import static hexlet.code.io.Printer.printfLn;
import static hexlet.code.io.Printer.println;

public class Greeter {
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String NAME_QUESTION = "May I have your name? ";
    private static final String GREETING_MESSAGE_TEMPLATE = "\nHello, %s!\n";

    public static String greetAndReturnUserName() {
        printGreeting();

        askName();
        var userName = readLine();

        sayHelloWithName(userName);

        return userName;
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
