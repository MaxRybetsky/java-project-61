package hexlet.code.io;

public class Printer {
    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printfLn(String template, Object... args) {
        System.out.printf(template, args);
        System.out.println();
    }

    public static void printf(String template, Object... args) {
        System.out.printf(template, args);
    }
}
