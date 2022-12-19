package quizGame;

import java.util.Scanner;

public class DisplayQuiz {

    static Scanner scanner = new Scanner(System.in);

    public static void printTitle() {
        System.out.println("\n" +
                "░██████╗░██╗░░░██╗██╗███████╗  ░██████╗░░█████╗░███╗░░░███╗███████╗\n" +
                "██╔═══██╗██║░░░██║██║╚════██║  ██╔════╝░██╔══██╗████╗░████║██╔════╝\n" +
                "██║██╗██║██║░░░██║██║░░███╔═╝  ██║░░██╗░███████║██╔████╔██║█████╗░░\n" +
                "╚██████╔╝██║░░░██║██║██╔══╝░░  ██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░\n" +
                "░╚═██╔═╝░╚██████╔╝██║███████╗  ╚██████╔╝██║░░██║██║░╚═╝░██║███████╗\n" +
                "░░░╚═╝░░░░╚═════╝░╚═╝╚══════╝  ░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝");

    }

    public static void printError(String message) {
        System.out.println(Colors.ANSI_RED + message + Colors.ANSI_RESET);
    }


    public static void printMenu() {
        printTitle();
        System.out.println("\nWelcome to " + Colors.ANSI_CYAN + "QUIZ GAME" + Colors.ANSI_RESET + "! Choose an option in the menu to continue...");
        System.out.println("\n(1) - Start playing");
        System.out.println("(2) - Rules and legend");
        System.out.println("(3) - Exit\n");
    }

    public static void printRules() {
        System.out.println("In " + Colors.ANSI_CYAN + "QUIZ GAME" + Colors.ANSI_RESET + ", 10 questions separate each participant from the 50 000 euros prize. Each has a different cash value.\n" +
                "\n- The first is worth 0€. The last, 50 000€." +
                "The player starts at level of 200€.");
        System.out.println("\n- The participant sees the question on the screen before deciding whether to answer.");
        System.out.println("\n- If you reach level of 0€, you lose the Game!");
        System.out.println("\n-If you get it right, you're still in the game and in the dispute for 50 000€.You increase one level. If you get it wrong, the value decreases one level.");
        System.out.println("\n- Always remembering that the challenger sees the question before it is asked if he want to use any help.");
        System.out.println();
        System.out.println(Colors.ANSI_BLUE + "The aids available:" + Colors.ANSI_RESET);
        System.out.println("At any time during their participation in Quiz, the challenger can draw on three aids.\n" +
                "\n" +
                "The help is represented by: " + Colors.ANSI_BLUE +
                "\n1 - the opinion of the audience (\uD83D\uDC68)\n" +
                "2 - the half and half (\uD835\uDFE7\uD835\uDFE2/\uD835\uDFE7\uD835\uDFE2)\n" +
                "3 - the call to a friend (\uD83D\uDCDE)" + Colors.ANSI_RESET);
        System.out.println("Without further questions...lets start the game!");
        System.out.println(Colors.ANSI_BLUE_BACKGROUND + "Press any key to continue..." + Colors.ANSI_RESET);
        scanner.nextLine();

    }

}
