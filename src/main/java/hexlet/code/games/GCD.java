package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

    private final Engine engine;
    private int countCorrect = 0;
    private final int MAX_CORRECT = 3;
    private boolean hasNoWrongAnswer = true;

    public GCD(Engine engine) {
        this.engine = engine;
    }

    public void startGame() {
        engine.greetUser();
        engine.showMessage(getGameRulesMessage());
        while (shouldContinueGame()) {
            int a = engine.getRandomNumber();
            int b = engine.getRandomNumber();
            engine.showMessage(getQuestionMessage(a, b));
            String userAnswer = engine.askUserAnswer();
            String correctAnswer = getCorrectAnswer(a, b);
            if (userAnswer.equals(correctAnswer)) {
                processCorrectAnswer();
            } else {
                processWrongAnswer(userAnswer, correctAnswer);
            }
        }

    }

    private String getQuestionMessage(int a, int b) {
        return "Question: " + a + " " + b;
    }

    private String getGameRulesMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private String getCorrectAnswer(int a, int b) {
        return String.valueOf(getGCD(a, b));
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
}
