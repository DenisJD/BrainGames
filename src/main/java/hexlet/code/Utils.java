package hexlet.code;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static final int MAX_RANDOM_NUMBER = 100;

    public static int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(MAX_RANDOM_NUMBER);
    }

    /**
     * @param from from inclusive
     * @param to   to exclusive
     * @return random number in range from...to
     */
    public static int getRandomNumber(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}
