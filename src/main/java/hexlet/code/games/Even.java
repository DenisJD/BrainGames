package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static void startGame() {
        String rulesMessage = "Answer 'yes' if number even otherwise answer 'no'.";
        while (Engine.getFlag()) {
            int number = Utils.getRandomNumber();
            String question = String.valueOf(number);
            String correctAnswer = number % 2 == 0 ? "yes" : "no";
            Engine.gameProcess(rulesMessage, question, correctAnswer);
        }
    }
}
