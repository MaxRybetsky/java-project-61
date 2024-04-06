package hexlet.code.random;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();
    private static final int DEFAULT_INT_BOUND = 100;

    public static int generateInteger() {
        return generateIntegerUpTo(DEFAULT_INT_BOUND);
    }

    public static int generateIntegerUpTo(int bound) {
        return RANDOM.nextInt(bound);
    }
}
