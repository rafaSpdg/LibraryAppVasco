package BattleShip;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {
    private final int length; // one variable for rows = columns = 10
    private String[][] board;
    private int numShips = 0;
    public static final String HIT = "💥";
    public static final String MISS = "💧";
    public static final String SHIP = "⛴";
    public static final String WATER = "🌊";

    public Board(int length) {
        this.length = length;
        board = initBoard();
    }

    public Board(String[][] matrix) {
        this.length = matrix.length;
        board = matrix;
    }

    private String[][] initBoard() {
        String[][] matrix = new String[length][length];
        for (String[] row : matrix) {
            Arrays.fill(row, WATER);
        }
        return matrix;
    }

    public int getLength() {
        return length;
    }

    public int getNumShips() {
        return numShips;
    }

    public String[][] getBoard() {
        return board;
    }

    public String at(Position1 position) {

        return board[position.getRow()][position.getColumn()];
    }

    public boolean set(String status, Position1 position) {
        board[position.getRow()][position.getColumn()] = status;
        return true;
    }

    public boolean thereIsShip(Position1 position) {
        return at(position) == SHIP;
    }

    public boolean thereIsWater(Position1 position) {
        return at(position) == WATER;
    }

    public boolean thereIsMiss(Position1 position) {
        return at(position) == MISS;
    }

    public boolean thereIsHit(Position1 position) {
        return at(position) == HIT;
    }

    public boolean thereIsSpace(Ship ship) {
        int l = ship.getLength();
        int x = ship.getPosition().getRow();
        int y = ship.getPosition().getColumn();

        if (ship.getDirection() == Direction.HORIZONTAL) {
            return (length - y + 1) > l;
        } else {
            return (length - x + 1) > l;
        }
    }

    public boolean isNearShip(Ship ship) throws PositionException {
        int k = 0;
        int row;
        int column;
        row = ship.getPosition().getRow();
        column = ship.getPosition().getColumn();

        if (ship.getDirection() == Direction.HORIZONTAL) {
            k = column;
        } else {
            k = row;
        }

        for (int i = 0; i < ship.getLength() && k + i < length - 1; i++) {
            if (isShipAround(row, column)) {
                return true;
            }

            if (ship.getDirection() == Direction.HORIZONTAL) {
                column++;
            } else if (ship.getDirection() == Direction.VERTICAL) {
                row++;
            }
        }
        return false;
    }

    private boolean isShipAround(int row, int column) throws PositionException {
        List<Position1> list = getAllNearPositions(row, column);
        for (Position1 position : list) {
            if (at(position) == SHIP) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Position1> getPossibleTarget(Position1 position) throws PositionException {
        int row = position.getRow();
        int column = position.getColumn();

        ArrayList<Position1> list = new ArrayList<>();

        //up
        if (row - 1 >= 0 && !thereIsMiss(new Position1(row - 1, column)) && !thereIsHit(new Position1(row - 1, column))) {
            list.add(new Position1(row - 1, column));
        }

        //left1
        if (column - 1 >= 0 && !thereIsMiss(new Position1(row, column - 1)) && !thereIsHit(new Position1(row, column - 1))) {
            list.add(new Position1(row, column - 1));
        }

        //down
        if (row + 1 < length && !thereIsMiss(new Position1(row + 1, column)) && !thereIsHit(new Position1(row + 1, column))) {
            list.add(new Position1(row + 1, column));
        }

        //right
        if (column + 1 < length && !thereIsMiss(new Position1(row, column + 1)) && !thereIsHit(new Position1(row, column + 1))) {
            list.add(new Position1(row, column + 1));
        }
        return list;
    }

    public ArrayList<Position1> getAllNearPositions(int row, int column) throws PositionException {
        List<Position1> list = new ArrayList<>();

        //Up
        if (row - 1 >= 0) {
            list.add(new Position1(row - 1, column));
        }

        //down
        if (row + 1 < length) {
            list.add(new Position1(row + 1, column));
        }

        //left
        if (column - 1 >= 0) {
            list.add(new Position1(row, column - 1));
        }

        //right
        if (column + 1 < length) {
            list.add(new Position1(row, column + 1));
        }

        //diagonal
        if (row - 1 >= 0 && column + 1 < length) {
            list.add(new Position1(row - 1, column + 1));
        }

        //diagonal
        if (row - 1 >= 0 && column - 1 >= 0) {
            list.add(new Position1(row - 1, column - 1));
        }

        //diagonal
        if (row + 1 < length && column + 1 < length) {
            list.add(new Position1(row + 1, column + 1));
        }

        //diagonal
        if (row + 1 < length && column - 1 >= 0) {
            list.add(new Position1(row + 1, column + 1));
        }

        return (ArrayList<Position1>) list;
    }

    public boolean addShip(Ship ship) throws BoardException, PositionException {
        int k = 0;
        int row;
        int column;
        if (!thereIsShip(ship.getPosition())) {
            if (thereIsSpace(ship)) {
                if (!isNearShip(ship)) {
                    row = ship.getPosition().getRow();
                    column = ship.getPosition().getColumn();
                    for (int i = 0; i < ship.getLength() && k + i < length; i++) {
                        if (ship.getDirection() == Direction.HORIZONTAL) {
                            if (i == 0) {
                                k = column;
                            }
                            board[row][column + i] = SHIP;
                        } else if (ship.getDirection() == Direction.VERTICAL) {
                            if (i == 0) {
                                k = row;
                            }
                            board[row + i][column] = SHIP;
                        }
                        numShips++;
                    }
                    return true;
                } else throw new BoardException("Error, another ship is nearby.");
            } else throw new BoardException("Error, there is no room for that ship with that heading.");
        } else throw new BoardException("Error, there is already a ship in that position");
    }

    public boolean addHit(Position1 position) throws BoardException {
        if (thereIsShip(position)) {
            numShips--;
            return set(HIT, position);
        } else if (thereIsWater(position)) {
            return set(MISS, position);
        } else {
            throw new BoardException("Error, you have already fired at this location.");
        }
    }

    public Position randPositionFromList(ArrayList<Position> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public Board getBoardHideShips() throws PositionException {
        String[][] matrix = new String[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!thereIsShip(new Position1(i, j))) {
                    matrix[i][j] = at(new Position1(i, j));
                } else {
                    matrix[i][j] = WATER;
                }
            }
        }
        return new Board(matrix);
    }

    public void reset() {
        numShips = 0;
        board = initBoard();
    }
}