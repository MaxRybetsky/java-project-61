package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void run() {
        printGreeting();

        askName();
        var userName = getNameFromInput();

        sayHelloWithName(userName);
    }

    private static void printGreeting() {
        System.out.println("Welcome to the Brain Games!");
    }

    private static void askName() {
        System.out.print("May I have your name? ");
    }

    private static String getNameFromInput() {
        var scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private static void sayHelloWithName(String userName) {
        System.out.printf("Hello, %s!\n", userName);
    }
}
