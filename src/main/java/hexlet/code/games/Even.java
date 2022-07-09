package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    private final Engine engine;
    private int countCorrect = 0;
    private final int MAX_CORRECT = 3;
    private boolean hasNoWrongAnswer = true;

    public Even(Engine engine) {
        this.engine = engine;
    }

    public void startGame() {
        engine.greetUser();
        engine.showMessage(getGameRulesMessage());
        countCorrect = 0;

        while (shouldContinueGame()) {
            int randomNumber = engine.getRandomNumber();
            engine.showMessage(getQuestionMessage(randomNumber));

            String userAnswer = engine.askUserAnswer();
            String correctAnswer = getCorrectAnswer(randomNumber);
            if (correctAnswer.equals(userAnswer)) {
                processCorrectAnswer();
            } else {
                processWrongAnswer(correctAnswer, userAnswer);
            }
        }
    }

    private void processWrongAnswer(String correctAnswer, String userAnswer) {
        engine.showMessage(getWrongAnswerMessage(correctAnswer, userAnswer));
        hasNoWrongAnswer = false;
    }

    private boolean shouldContinueGame() {
        return countCorrect < MAX_CORRECT && hasNoWrongAnswer;
    }

    private String getQuestionMessage(int number) {
        return "Question: " + number;
    }

    private String getWrongAnswerMessage(String correctAnswer, String userAnswer) {
        return "'"
                + userAnswer + "' is wrong answer ;(. Correct answer was '"
                + correctAnswer
                + "'"
                + "\n"
                + "Let's try again, " + engine.getUserName() + "!";
    }

    private void processCorrectAnswer() {
        countCorrect++;
        engine.showMessage("Correct!");
        if (countCorrect == MAX_CORRECT) {
            engine.showMessage("Congratulations, " + engine.getUserName() + "!");
        }
    }

    private String getCorrectAnswer(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }

    private String getGameRulesMessage() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }
}
