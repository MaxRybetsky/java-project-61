package hexlet.code.random;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();

    public static int generateIntegerFromRange(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }
}
