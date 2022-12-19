package BattleShip;

public class Ship {

    private String name;
    private int length;
    private Position1 position1;
    private Direction direction;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.position1 = null;
        this.direction = null;
    }

    public Ship(String name, int length, Position1 position1, Direction direction) {
        this.name = name;
        this.length = length;
        this.position1 = position1;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Position1 getPosition() {
        return position1;
    }

    public void setPosition(Position1 position1) {
        this.position1 = position1;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String toGraphicLength() {
        return ("" + Board.SHIP).repeat(length);
    }

    public String toString() {
        return name + ";" + length;
    }
}
