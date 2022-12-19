package quizGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static int readOption(Scanner sc, String message) {
        try {
            System.out.print(message);
            return Integer.parseInt(sc.next());
        } catch (NumberFormatException | InputMismatchException e) {
            DisplayQuiz.printError("Error, enter a number to continue.");
            return readOption(sc, message);
        }
    }
}
