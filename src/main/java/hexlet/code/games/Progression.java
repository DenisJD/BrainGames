package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import org.apache.commons.lang3.StringUtils;

public class Progression {
    public static final int MIN_ARRAY_SIZE = 5;
    public static final int MAX_ARRAY_SIZE = 11;
    public static final int MIN_START_NUMBER = 10;
    public static final int MAX_START_NUMBER = 50;
    public static final int MIN_DELTA = 3;
    public static final int MAX_DELTA = 12;

    public static void startGame() {
        String rulesMessage = "What number is missing in the progression?";
        while (Engine.getFlag()) {
            int[] progression = createProgression();
            int hideNumberIndex = Utils.getRandomNumber(0, progression.length);
            String question = getQuestionMessage(progression, hideNumberIndex);
            String correctAnswer = String.valueOf(progression[hideNumberIndex]);
            Engine.gameProcess(rulesMessage, question, correctAnswer);
        }
    }

    public static int[] createProgression() {
        int arraySize = Utils.getRandomNumber(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
        int startNumber = Utils.getRandomNumber(MIN_START_NUMBER, MAX_START_NUMBER);
        int delta = Utils.getRandomNumber(MIN_DELTA, MAX_DELTA);
        int[] progression = new int[arraySize];
        progression[0] = startNumber;
        for (int i = 1; i < arraySize; i++) {
            progression[i] = progression[i - 1] + delta;
        }
        return progression;
    }

    public static String getQuestionMessage(int[] progression, int hideNumberIndex) {
        Object[] stringProgression = new String[progression.length];
        for (int i = 0; i < progression.length; i++) {
            stringProgression[i] = String.valueOf(progression[i]);
        }
        String hiddenNumber = "..";
        stringProgression[hideNumberIndex] = hiddenNumber;
        String delimiter = " ";
        return StringUtils.joinWith(delimiter, stringProgression);
    }
}
