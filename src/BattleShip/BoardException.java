package BattleShip;

public class BoardException extends Exception {
    String message;
    public BoardException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
