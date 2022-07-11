package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private final Engine engine;
    private final int MAX_CORRECT = 3;
    private int countCorrect = 0;
    private boolean hasNoWrongAnswer = true;

    public Prime(Engine engine) {
        this.engine = engine;
    }

    public void startGame() {
        engine.greetUser();
        engine.showMessage(getGameRulesMessage());
        countCorrect = 0;
        while (shouldContinueGame()) {
            int a = engine.getRandomNumber(2, 100);
            engine.showMessage(getQuestionMessage(a));
            String userAnswer = engine.askUserAnswer();
            String correctAnswer = getCorrectAnswer(a);
            if (userAnswer.equals(correctAnswer)) {
                processCorrectAnswer();
            } else {
                processWrongAnswer(userAnswer, correctAnswer);
            }
        }
    }

    private String getGameRulesMessage() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    private boolean shouldContinueGame() {
        return countCorrect < MAX_CORRECT && hasNoWrongAnswer;
    }

    private String getQuestionMessage(int a) {
        return "Question: " + a;
    }

    private boolean isNumberPrime(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    private String getCorrectAnswer(int a) {
        if (isNumberPrime(a)) {
            return "yes";
        }
        return "no";
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
}
