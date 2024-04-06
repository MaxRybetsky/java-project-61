package hexlet.code;

import java.util.Scanner;

public class Greeter {
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String NAME_QUESTION = "May I have your name? ";
    private static final String GREETING_MESSAGE_TEMPLATE = "Hello, %s!\n";

    public static String greetAndReturnUserName() {
        printGreeting();

        askName();
        var userName = getNameFromInput();

        sayHelloWithName(userName);

        return userName;
    }

    private static void printGreeting() {
        System.out.println(WELCOME_MESSAGE);
    }

    private static void askName() {
        System.out.print(NAME_QUESTION);
    }

    private static String getNameFromInput() {
        var scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private static void sayHelloWithName(String userName) {
        System.out.printf(GREETING_MESSAGE_TEMPLATE, userName);
    }
}
