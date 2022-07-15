package hexlet.code;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    /**
     * @param from from inclusive
     * @param to   to exclusive
     * @return random number in range from...to
     */
    public static int getRandomNumber(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}
