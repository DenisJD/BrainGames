package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.StringUtils;

public class Progression {
    private final Engine engine;
    private int countCorrect = 0;
    private final int MAX_CORRECT = 3;
    private boolean hasNoWrongAnswer = true;
    private final String HIDDEN_NUMBER = "..";
    private final String DELIMITER = " ";

    public Progression(Engine engine) {
        this.engine = engine;
    }

    public void startGame() {
        engine.greetUser();
        engine.showMessage(getGameRulesMessage());
        while (shouldContinueGame()) {
            int[] progression = createProgression();
            int hideNumberIndex = engine.getRandomNumber(0, progression.length);
            String correctAnswer = String.valueOf(progression[hideNumberIndex]);
            engine.showMessage(getQuestionMessage(progression,hideNumberIndex));
            String userAnswer = engine.askUserAnswer();
            if (userAnswer.equals(correctAnswer)) {
                processCorrectAnswer();
            } else {
                processWrongAnswer(userAnswer, correctAnswer);
            }
        }

    }

    private int[] createProgression() {
        int arraySize = engine.getRandomNumber(5, 11);
        int startNumber = engine.getRandomNumber(10, 50);
        int delta = engine.getRandomNumber(3, 12);
        int[] progression = new int[arraySize];
        progression[0] = startNumber;
        for (int i = 1; i < arraySize; i++) {
            progression[i] = progression[i - 1] + delta;
        }
        return progression;
    }

    private String getProgressionForQuestion(int[] progression, int hideNumberIndex) {
        Object[] stringProgression = new String[progression.length];
        for (int i = 0; i < progression.length; i++) {
            stringProgression[i] = String.valueOf(progression[i]);
        }
        stringProgression[hideNumberIndex] = HIDDEN_NUMBER;
        return StringUtils.joinWith(DELIMITER, stringProgression);
    }

    private String getGameRulesMessage() {
        return "What number is missing in the progression?";
    }

    private void processCorrectAnswer() {
        countCorrect++;
        engine.showCorrectAnswerMessage();
        if (countCorrect == MAX_CORRECT) {
            engine.showGameWinMessage();
        }
    }

    private void processWrongAnswer(String userAnswer, String correctAnswer) {
        engine.showWrongAnswerMessage(correctAnswer, userAnswer);
        hasNoWrongAnswer = false;
    }

    private boolean shouldContinueGame() {
        return countCorrect < MAX_CORRECT && hasNoWrongAnswer;
    }

    private String getQuestionMessage(int[] progression, int hideNumberIndex) {
        String progressionString = getProgressionForQuestion(progression, hideNumberIndex);
        return "Question: " + progressionString;
    }
}
