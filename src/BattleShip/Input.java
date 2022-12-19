package BattleShip;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static Position1 readPosition(Scanner sc, Board board, String message) {
        try {
            System.out.print(message);
            String s = sc.nextLine().toLowerCase();
            char row = s.charAt(0);
            int column = Integer.parseInt(s.substring(1));
            Position1.isInRange(row, column, board);
            return new Position1(row, column - 1);
        } catch (PositionException | NumberFormatException | StringIndexOutOfBoundsException e) {
            Display.printError("Error,allowed values between a1 and " + Position1.encode(board.getLength() - 1) + board.getLength());
            return readPosition(sc, board, message);
        }

    }

    public static Direction readDirection(Scanner sc, String message) {
        try {
            System.out.print(message);
            String s = sc.nextLine();
            return Direction.decode(s.charAt(0));
        } catch (DirectionException | StringIndexOutOfBoundsException e) {
            Display.printError("Error, allowed values between directions 'h' or 'v'");
            return readDirection(sc, message);
        }
    }

    public static int readOption(Scanner sc, String message) {
        try {
            System.out.print(message);
            return Integer.parseInt(sc.next());
        } catch (NumberFormatException | InputMismatchException e) {
            Display.printError("Error, enter a number to continue.");
            return readOption(sc, message);
        }
    }
}
