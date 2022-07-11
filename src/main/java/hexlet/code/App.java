package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {
        getFirstMessage();
        getChooseGameMessage();
        chooseGame();
    }
    public static void getFirstMessage(){
        System.out.println("Please enter the game number and press Enter.");;
    }
    public static void getChooseGameMessage(){
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
    }
    public static void chooseGame(){
        Scanner scanner = new Scanner(System.in);
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
            case "6" -> {
                Engine engine = new Engine(scanner, ThreadLocalRandom.current());
                new Prime(engine).startGame();
            }
            default -> {
            }
        }
        scanner.close();
    }
}
