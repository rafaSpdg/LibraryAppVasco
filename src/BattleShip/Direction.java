package BattleShip;

public enum Direction {
    HORIZONTAL,
    VERTICAL;

    public static Direction decode(char c) throws DirectionException {
        if(c == 'h' || c == 'H') {
            return HORIZONTAL;
        } else if(c == 'v' || c == 'V') {
            return VERTICAL;
        } else {
            throw new DirectionException("The  character '"+c+"' cannot be converted in one direction.");
        }
    }

    public static Direction decode(String direction) throws DirectionException {
        if(direction.equalsIgnoreCase("horizontal")) {
            return HORIZONTAL;
        } else if(direction.equalsIgnoreCase("vertical")) {
            return VERTICAL;
        } else {
            throw new DirectionException("The string '"+direction+"' cannot be converted in one direction.");
        }
    }
}
