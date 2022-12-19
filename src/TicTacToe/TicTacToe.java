package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        char[] pos = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};


        System.out.println("   TIC-TAC-TOE GAME   ");

        printBoard();

        System.out.println();

        char turn = 'X';
        int choice;
        int countRounds = 0;


        while (true) {

            do {
                System.out.print("Enter a position: ");
                choice = scanner.nextInt();
            } while (pos[choice - 1] == 'X' || pos[choice - 1] == 'O');


            pos[choice - 1] = turn;

            System.out.println();
            System.out.println(" " + pos[6] + " | " + pos[7] + " | " + pos[8] + " ");
            System.out.println("---+---+---");
            System.out.println(" " + pos[3] + " | " + pos[4] + " | " + pos[5] + " ");
            System.out.println("---+---+---");
            System.out.println(" " + pos[0] + " | " + pos[1] + " | " + pos[2] + " ");

            if (pos[0] == turn && pos[1] == turn && pos[2] == turn
                    || pos[3] == turn && pos[4] == turn && pos[5] == turn
                    || pos[6] == turn && pos[7] == turn && pos[8] == turn
                    || pos[0] == turn && pos[4] == turn && pos[8] == turn
                    || pos[2] == turn && pos[4] == turn && pos[6] == turn
                    || pos[0] == turn && pos[3] == turn && pos[6] == turn
                    || pos[1] == turn && pos[4] == turn && pos[7] == turn
                    || pos[2] == turn && pos[5] == turn && pos[8] == turn) {
                System.out.println(turn + " is the WINNER!");
                break;
            }

            countRounds++;

            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }


            if (countRounds >= 9) {
                System.out.println("Draw.");
                break;
            }

            System.out.println();
        }

    }

    public static void printBoard() {
        System.out.println();
        System.out.println(" 7 | 8 | 9 ");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---+---+---");
        System.out.println(" 1 | 2 | 3 ");
    }
}

