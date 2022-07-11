package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    private final Engine engine;

    private final int MAX_CORRECT = 3;
    private int countCorrect = 0;
    private boolean hasNoWrongAnswer = true;

    public Calc(Engine engine) {
        this.engine = engine;
    }

    public void startGame() {
        engine.greetUser();
        engine.showMessage(getGameRulesMessage());
        countCorrect = 0;
        while (shouldContinueGame()) {
            int a = engine.getRandomNumber();
            int b = engine.getRandomNumber();
            char mathOperator = getMathOperator();

            engine.showMessage(getQuestionMessage(a, b, mathOperator));
            String userAnswer = engine.askUserAnswer();
            String correctAnswer = getCorrectAnswer(a, b, mathOperator);
            if (userAnswer.equals(correctAnswer)) {
                processCorrectAnswer();
            } else {
                processWrongAnswer(userAnswer, correctAnswer);
            }
        }
    }

    private void processWrongAnswer(String userAnswer, String correctAnswer) {
        engine.showWrongAnswerMessage(correctAnswer, userAnswer);
        hasNoWrongAnswer = false;
    }

    private void processCorrectAnswer() {
        countCorrect++;
        engine.showCorrectAnswerMessage();
        if (countCorrect == MAX_CORRECT) {
            engine.showGameWinMessage();
        }
    }

    private boolean shouldContinueGame() {
        return countCorrect < MAX_CORRECT && hasNoWrongAnswer;
    }

    private String getCorrectAnswer(int a, int b, char mathOperator) {
        int correctAnswer = 0;
        if (mathOperator == '+') {
            correctAnswer = a + b;
        } else if (mathOperator == '-') {
            correctAnswer = a - b;
        } else if (mathOperator == '*') {
            correctAnswer = a * b;
        }
        return String.valueOf(correctAnswer);
    }

    private char getMathOperator() {
        return "+-*".charAt(engine.getRandomNumber(0, 3));
    }

    private String getGameRulesMessage() {
        return "What is the result of the expression?";
    }

    private String getQuestionMessage(int a, int b, char mathOperator) {
        return "Question: " + a + " " + mathOperator + " " + b;
    }
}
