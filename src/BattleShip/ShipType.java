package BattleShip;

public enum ShipType {

    SUBMARINE(3, 2),
    CRUISER(2, 3),
    DESTROYER(2, 4),
    AIRCRAFTSHIP(1, 5);

    private final int numShips;
    private final int shipLength;

    ShipType(int numShips, int shipLength) {
        this.numShips = numShips;
        this.shipLength = shipLength;
    }

    public int getNumShips() {
        return numShips;
    }

    public int getShipLength() {
        return shipLength;
    }

    public static int lengthAllShips() {
        int sum = 0;
        for(ShipType type : ShipType.values()) {
            sum += type.shipLength * type.numShips;
        }
        return sum;
    }

    public static int sizeAllShips() {
        int sum = 0;
        for(ShipType type : ShipType.values()) {
            sum += type.numShips;
        }
        return sum;
    }
}
