package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstMessage = "Please enter the game number and press Enter.";
        String chooseGame = "1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n0 - Exit";
        System.out.println(firstMessage);
        System.out.println(chooseGame);

        System.out.print("Your choice: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                Engine engine = new Engine(scanner, ThreadLocalRandom.current());
                new Cli(engine).greetings();
            }
            case "2" -> {
                Engine engine = new Engine(scanner, ThreadLocalRandom.current());
                new Even(engine).startGame();
            }
            case "3" -> {
                Engine engine = new Engine(scanner, ThreadLocalRandom.current());
                new Calc(engine).startGame();
            }
            case "4" -> {
                Engine engine = new Engine(scanner, ThreadLocalRandom.current());
                new GCD(engine).startGame();
            }
            case "5" -> {
                Engine engine = new Engine(scanner, ThreadLocalRandom.current());
                new Progression(engine).startGame();
            }
            default -> {
            }
        }

        scanner.close();
    }
}
