package BattleShip;

public class Position1 {
    private final int row;
    private final int column;

    public Position1(int row, int column) throws PositionException {
        if( row < 0 || column < 0) {
            throw new PositionException("Values allowed greater than 1. ");
        }
        this.row = row;
        this.column = column;
    }

    public Position1(char row , int column) throws PositionException {
        if (row < 'a' || column < 0) {
            throw new PositionException("Values allowed greater than a1.");
        }
        this.row = decode(row);
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public static int decode(char row) {
        return row - 'a';
    }

    public static char encode(int row) {
        return (char)('a' - row);
    }

    public String toStringEncode(Position1 position1){
        return "(" + (char)('a' + position1.getRow()) + "," + (position1.getColumn() + 1) + ")";

    }

    public static boolean isInRange(char row,int column,Board board) throws PositionException {
        int decodeRow = decode(row);
        if(decodeRow >= board.getLength() || column > board.getLength() || decodeRow < 0 || column < 0) {
            throw new PositionException ("Error,allowed values between a1 and " + Position1.encode(board.getLength() - 1) + board.getLength());
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "(" + row + "," + column + ")";
    }
}
