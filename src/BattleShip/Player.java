package BattleShip;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private String name;
    private final Board board = new Board(10);
    private final ArrayList<Position1> shoots = new ArrayList<>();
    private final ArrayList<Position1> nextTargets = new ArrayList<>();
    private boolean isComputer;

    public Player() {
        name = randName();
        isComputer = true;
    }

    public Player(String name) {
        this.name = name;
        isComputer = false;
    }

    public Player(String name, boolean isComputer) {
        this.name = name;
        this.isComputer = isComputer;
    }

    public Player(boolean isComputer) {
        this.name = randName();
        this.isComputer = isComputer;
    }

    private ArrayList<Ship> initShips() {
        ArrayList<Ship> list = new ArrayList<>();
        for (ShipType type : ShipType.values()) {
            for (int i = 0; i < type.getNumShips(); i++) {
                list.add(new Ship(type.toString(), type.getShipLength()));
            }
        }
        return list;
    }

    private String randName() {
        Random rand = new Random();
        String letters = "abcdefghijklmnopgrstuvxz";
        String name = "";
        int maxLung = 10;
        int minLung = 3;
        int l = rand.nextInt(maxLung - minLung) + minLung;
        for (int i = 0; i < l; i++) {
            name += letters.charAt((rand.nextInt(letters.length())));
        }

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Position1> getShoots() {
        return shoots;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void addAllShips() {
        if (isComputer) {
            boolean isAdded;
            Position1 position;
            Direction direction;
            String messagePosition = "-Enter the coordinate (e.g. A1):";
            String messageDirection = "- Enter the direction (e.g. h/v:";
            Scanner scanner = new Scanner(System.in);
            ArrayList<Ship> list = initShips();

            for (int i = 0; i < list.size(); i++) {
                Ship ship = list.get(i);
                do {
                    Display.printBoard(board);
                    Display.printCurrentShip(ship, countShip(list, ship.getLength()));

                    position = (Position1) Input.readPosition(scanner, board, messagePosition);
                    direction = Input.readDirection(scanner, messageDirection);
                    ship.setPosition(position);
                    ship.setDirection(direction);

                    try {
                        isAdded = board.addShip(ship);
                    } catch (BoardException | PositionException e) {
                        Display.printError(e.toString());
                        isAdded = false;
                    }
                } while (!isAdded);
                list.remove(i);
                i--;
            }
            Display.printBoard(board);
        } else {
            randAddAllShips();
        }
    }

    private void randAddAllShips() {
        Random rand = new Random();
        ArrayList<Ship> list = initShips();

        boolean isAdded;
        Position1 position;
        Direction direction;
        int deadlock = 0;
        int limit = 1000;

        for (int i = 0; i < list.size(); i++) {
            Ship ship = list.get(i);
            deadlock = 0;

            do {
                try {
                    position = new Position1(board.getLength(), rand.nextInt(board.getLength()));
                    direction = rand.nextBoolean() ? Direction.VERTICAL : Direction.HORIZONTAL;
                    ship.setDirection(direction);
                    ship.setPosition(position);
                    isAdded = board.addShip(ship);
                } catch (BoardException | PositionException e) {
                    isAdded = false;
                }
                if (!isAdded) {
                    deadlock++;
                }
                if (deadlock > limit) {
                    reset();
                    i = -1;
                    break;
                }
            } while (!isAdded);
        }
    }

    public boolean hasShipsLive() {
        return board.getNumShips() > 0;
    }

    private int countShip(ArrayList<Ship> ships, int length) {
        int count = 0;
        for (Ship ship : ships) {
            if (ship.getLength() == length) {
                count++;
            }
        }
        return count;
    }

    public int shipsLeft() {
        return board.getNumShips();
    }

    private Position1 randPosition() throws PositionException {
        Random rand = new Random();
        int x = rand.nextInt(board.getLength());
        int y = rand.nextInt(board.getLength());
        return new Position1(x, y);
    }

    public boolean addShoot(Position1 pos) throws BoardException {
        return board.addHit(pos);
    }

    public Position1 shootAI(Board boardEnemy) throws PositionException {
        Position1 lastPos, nextPos;
        if (shoots.isEmpty()) {
            return randPosition();
        } else {
            lastPos = getLastShoot();
            nextTargets.addAll(boardEnemy.getPossibleTarget(lastPos));
            if (nextTargets.isEmpty()) {
                return randPosition();
            }
            nextPos = nextTargets.get(0);
            nextTargets.remove(0);
            return nextPos;
        }
    }

    public Position1 shoot(Board boardEnemy) throws PositionException {
        if (isComputer) {
            return shootAI(boardEnemy);
        } else {
            Scanner sc = new Scanner(System.in);
            return Input.readPosition(sc, board, "- " + name + ", where do you want to shoot? ");
        }
    }

    public void registerShoot(Position1 position) {
        shoots.add(position);
    }

    public Position1 getLastShoot() {
        if (shoots.isEmpty()) {
            return null;
        }
        return shoots.get(shoots.size() - 1);
    }

    private void reset() {
        board.reset();
    }
}
