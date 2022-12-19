package BattleShip;

import java.util.Scanner;

public class Game {
    private Player p1;
    private Player p2;
    private String computer = "PC";

    public Game(String name) {
        p1 = new Player(name);
        p2 = new Player(computer, true);
    }

    public Game() {
        p1 = new Player(computer + "1", true);
        p2 = new Player(computer + "2", true);
    }

    private boolean turn(Player attack, Player defend) throws PositionException {
        Position1 shoot = null;
        boolean isHit;
        boolean isAddHit;
        if (attack.hasShipsLive()) {
            do {
                try {
                    shoot = attack.shoot(defend.getBoard().getBoardHideShips());
                    isAddHit = defend.addShoot(shoot);
                } catch (BoardException e) {
                    if (!attack.isComputer()) {
                        Display.printError("Error, you have already shot at this location!");
                    }
                    isAddHit = false;
                }
            } while (!isAddHit);

            isHit = defend.getBoard().thereIsHit(shoot);

            if (isHit) {
                attack.registerShoot(shoot);
            }

            Display.printShot(attack, shoot, isHit);

            if (attack.isComputer() && defend.isComputer()) {
                Display.printAdjacentBoard(attack, defend);
            } else if (!attack.isComputer()) {
                Display.printAdjacentBoard(attack, defend);
            } else if (!defend.isComputer()) {
                Display.printAdjacentBoard(defend, attack);
            }

            if (!attack.isComputer() && !defend.isComputer()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
            return true;
        } else return false;
    }

    private void addAllShips() {
        p1.addAllShips();
        p2.addAllShips();
    }

    private void printResultGame() {
        if (p1.shipsLeft() > p2.shipsLeft()) {
            Display.printWinner(p1);
        }
        else Display.printWinner(p2);
    }

    public void run() throws PositionException {
        addAllShips();
        while (turn(p1, p2) && turn(p2, p1)) {
            printResultGame();
        }
    }

    public static void runGame() throws PositionException {
        Scanner scanner = new Scanner(System.in);
        Game game;
        String name = "";
        int option;
        boolean hasName = false;

        do {
            option = Display.printMenu();

            switch (option) {
                case 1:
                    if (!hasName) {
                        System.out.print("\nWrite here your name: ");
                        name = scanner.next();
                        hasName = true;
                        game = new Game(name);
                        game.run();
                    }
                    break;
                case 2:
                    game = new Game();
                    game.run();
                    Display.printCredits();
                    break;
                case 3:
                    Display.printRules();
                    break;
            }
        } while (option != 0);

    }
}
