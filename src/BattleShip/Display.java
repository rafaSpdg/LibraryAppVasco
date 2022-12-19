package BattleShip;

import java.util.Scanner;

public class Display {
    public static void printTitle() {
        System.out.println("" +
                "\n" +
                "██████╗░░█████╗░████████╗████████╗██╗░░░░░███████╗░██████╗██╗░░██╗██╗██████╗░\n" +
                "██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║░░░░░██╔════╝██╔════╝██║░░██║██║██╔══██╗\n" +
                "██████╦╝███████║░░░██║░░░░░░██║░░░██║░░░░░█████╗░░╚█████╗░███████║██║██████╔╝\n" +
                "██╔══██╗██╔══██║░░░██║░░░░░░██║░░░██║░░░░░██╔══╝░░░╚═══██╗██╔══██║██║██╔═══╝░\n" +
                "██████╦╝██║░░██║░░░██║░░░░░░██║░░░███████╗███████╗██████╔╝██║░░██║██║██║░░░░░\n" +
                "╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░░░░╚═╝░░░╚══════╝╚══════╝╚═════╝░╚═╝░░╚═╝╚═╝╚═╝░░░░░");
    }

    public static int printMenu() {
        printTitle();
        System.out.println("\nWelcome to the Battleship game! Choose an item in the menu to continue...");
        System.out.println("\n(1) - Start playing");
        System.out.println("(2) - Simulate game");
        System.out.println("(3) - Rules and legend");
        System.out.println("(0) - Exit\n");
        return Input.readOption(new Scanner(System.in), "Response: ");
    }

    public static void printRules() {
        System.out.println(DisplayColors.ANSI_YELLOW + "\nHow to win:" + DisplayColors.ANSI_RESET);
        System.out.println(DisplayColors.ANSI_WHITE +
                "\n" +
                "- Each player has a battlefield represented by a 10x10 grid on which he places " + ShipType.sizeAllShips() + " ships, hidden from his opponent.\n" +
                "- The goal of the game is to sink all of your opponent's ships! A ship is sunk when hit once for each space it occupies.\n" +
                "- In other words, a " + (ShipType.values()[0]) + ", which it occupies " + ShipType.values()[0].getShipLength() + " spaces, is sunk after being hit 2 times.\n" +
                "- The" + ShipType.sizeAllShips() + " ships occupy " + ShipType.lengthAllShips() + " total spaces, so the first player to register 25 hits wins!" +
                DisplayColors.ANSI_RESET);

        System.out.println(DisplayColors.ANSI_YELLOW + "\nGameplay:" + DisplayColors.ANSI_RESET);
        System.out.println(DisplayColors.ANSI_WHITE +
                "- To play, follow the instructions to set up your " + ShipType.sizeAllShips() + " ships in any pattern you like (placements diagonal or adjacent to other ships are not allowed).\n" +
                "- To place a ship you need to enter a starting coordinate (A1-J10 for the default 10x10 board) and a direction (vertical or horizontal).\n" +
                "- For example: A1 or B7. Ships cannot overlap or adjacent (attached) and you must stay within the edge limits.\n" +
                "- Once both players have configured their ships, the battle can begin!\n" +
                "- Launch torpedoes at your opponent's ships by guessing the coordinates.\n" +
                "- Rows are represented by the letters A-J and columns by the numbers 1-10 (10x10 board).\n" +
                "- Valid coordinates include a row followed by a column, eg A1, B7, J10, etc.\n" +
                "- You will be notified if you hit or miss a ship.\n" +
                "- Sink all 8 computer ships to win!" +
                DisplayColors.ANSI_RESET);
        System.out.println(DisplayColors.ANSI_YELLOW + "\nLegend:" + DisplayColors.ANSI_RESET);
        for (ShipType type : ShipType.values()) {
            System.out.println(DisplayColors.ANSI_WHITE +
                    "- (" + DisplayColors.ANSI_YELLOW + Board.SHIP + DisplayColors.ANSI_WHITE + "x" + type.getShipLength() + ")\t: " + type +
                    DisplayColors.ANSI_RESET);
        }
        System.out.println(
                "- ( " + DisplayColors.ANSI_BLUE + Board.WATER + DisplayColors.ANSI_WHITE + " )\t: Water\n" +
                        "- (" + DisplayColors.ANSI_YELLOW + Board.SHIP + DisplayColors.ANSI_WHITE + ")\t: Ship\n" +
                        "- (" + DisplayColors.ANSI_RED + Board.HIT + DisplayColors.ANSI_WHITE + ")\t: Ship hit\n" +
                        "- (" + DisplayColors.ANSI_WHITE + Board.MISS + DisplayColors.ANSI_WHITE + ")\t: Miss\n");

        System.out.print("press any ket to continue...\n");
        new Scanner(System.in).nextLine();
    }

    public static void printCredits() {
        System.out.println("\nThank you for playing!");
    }

    public static void printError(String message) {
        System.out.println(DisplayColors.ANSI_RED + message + DisplayColors.ANSI_RESET);
    }

    public static void printShot(Player player, Position1 position1, boolean isHit) {
        System.out.println("- " + player.getName() + " shot into " + position1.toStringEncode(position1) + ": " +
                (isHit ? DisplayColors.ANSI_BLUE + "Hit!" + DisplayColors.ANSI_RESET :
                        DisplayColors.ANSI_RED + "Missed!" + DisplayColors.ANSI_RESET));
    }

    public static void printWinner(Player player) {
        System.out.println(DisplayColors.ANSI_BLUE + "\n✔ " + player.getName() + " won!" + DisplayColors.ANSI_RESET + "\n");
        System.out.print("Press any key to continue...\n");
        new Scanner(System.in).nextLine();
    }

    public static void printCurrentShip(Ship ship, int numShipLeft) {
        System.out.println("☛ " + ship.getName() + " (" +
                DisplayColors.ANSI_YELLOW + ship.toGraphicLength() + DisplayColors.ANSI_RESET +
                ") x" + numShipLeft);
    }

    public static void printAdjacentBoard(Player p1, Player p2) throws PositionException {
        System.out.println(toStringAdjacentBoard(p1, p2));
    }

    public static String toStringAdjacentBoard(Player p1, Player p2) throws PositionException {
        Board firstBoard = p1.getBoard();
        Board secondBoard = p2.getBoard().getBoardHideShips();
        String numbers = "⒈⒉⒊⒋⒌⒍⒎⒏⒐⒑";
        String letters = "ͣᵇͨͩͤᶠᶢͪͥʲ";
        String s = "\n――――――――――――――――――――――――――――――――――\n";
        s += "\n     ";

        for (int i = 0; i < firstBoard.getLength(); i++) s += " " + numbers.charAt(i) + "    ";
        s += "          ";
        for (int i = 0; i < secondBoard.getLength(); i++) s += " " + numbers.charAt(i) + "    ";


        s += "\n";
        for (int i = 0; i < firstBoard.getLength(); i++) {
            s += DisplayColors.ANSI_WHITE;
            if (i == 5) s += " " + letters.charAt(i) + "    "; //f
            else if (i == 6) s += letters.charAt(i) + "    "; //g
            else s += letters.charAt(i) + "  ";
            s += DisplayColors.ANSI_RESET;

            for (int j = 0; j < firstBoard.getLength(); j++) {
                if (firstBoard.getBoard()[i][j] == Board.WATER)
                    s += DisplayColors.ANSI_BLUE + " " + Board.WATER + " " + " " + DisplayColors.ANSI_RESET;
                else if (firstBoard.getBoard()[i][j] == Board.HIT)
                    s += DisplayColors.ANSI_RED + Board.HIT + " " + DisplayColors.ANSI_RESET;
                else if (firstBoard.getBoard()[i][j] == Board.MISS) s += Board.MISS + " " + DisplayColors.ANSI_RESET;
                else s += DisplayColors.ANSI_YELLOW + firstBoard.getBoard()[i][j] + " " + DisplayColors.ANSI_RESET;
            }

            s += "   ";

            s += DisplayColors.ANSI_WHITE;
            if (i == 5) s += " " + letters.charAt(i) + "    "; //f
            else if (i == 6) s += letters.charAt(i) + "    "; //g
            else s += letters.charAt(i) + "  ";
            s += DisplayColors.ANSI_RESET;

            for (int j = 0; j < secondBoard.getLength(); j++) {
                if (secondBoard.getBoard()[i][j] == Board.WATER)
                    s += DisplayColors.ANSI_BLUE + " " + Board.WATER + " " + " " + DisplayColors.ANSI_RESET;
                else if (secondBoard.getBoard()[i][j] == Board.HIT)
                    s += DisplayColors.ANSI_RED + Board.HIT + " " + DisplayColors.ANSI_RESET;
                else if (secondBoard.getBoard()[i][j] == Board.MISS) s += Board.MISS + " " + DisplayColors.ANSI_RESET;
                else s += DisplayColors.ANSI_YELLOW + secondBoard.getBoard()[i][j] + " " + DisplayColors.ANSI_RESET;
            }

            s += "\n";
        }
        s += "  " + p1.getName() + "\t\t\t\t\t    " + p2.getName();
        s += "\n――――――――――――――――――――――――――――――――――\n";
        return s;
    }

    public static void printBoard(Board board) {
        System.out.println(toStringBoard(board));
    }

    public static String toStringBoard(Board board) {
        String numbers = "⒈⒉⒊⒋⒌⒍⒎⒏⒐⒑";
        String letters = "ͣᵇͨͩͤᶠᶢͪͥʲ";
        String s = "\n     ";
        for (int i = 0; i < board.getLength(); i++) s += " " + numbers.charAt(i) + "    ";
        s += "\n";
        for (int i = 0; i < board.getLength(); i++) {
            s += DisplayColors.ANSI_WHITE;
            if (i == 5) s += " " + letters.charAt(i) + "    "; //f
            else if (i == 6) s += letters.charAt(i) + "    "; //g
            else s += letters.charAt(i) + "  ";

            for (int j = 0; j < board.getLength(); j++) {
                if (board.getBoard()[i][j] == Board.WATER)
                    s += DisplayColors.ANSI_BLUE + " " + Board.WATER + " " + " " + DisplayColors.ANSI_RESET;
                else if (board.getBoard()[i][j] == Board.HIT)
                    s += DisplayColors.ANSI_RED + Board.HIT + " " + DisplayColors.ANSI_RESET;
                else if (board.getBoard()[i][j] == Board.MISS)
                    s += DisplayColors.ANSI_WHITE + Board.MISS + " " + DisplayColors.ANSI_RESET;
                else s += DisplayColors.ANSI_YELLOW + board.getBoard()[i][j] + " " + DisplayColors.ANSI_RESET;
            }
            s += "\n";
        }
        return s;
    }
}
