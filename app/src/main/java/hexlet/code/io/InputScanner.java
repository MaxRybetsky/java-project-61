package hexlet.code.io;

import java.util.Scanner;

public class InputScanner {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readLine() {
        return SCANNER.nextLine();
    }
}
