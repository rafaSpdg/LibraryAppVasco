package quizGame;

public class MoneyTable {

    private static final String[] moneyLevel = {"0€", "200€", "500€", "1500€", "3000€", "5000€", "10000€", "20000€", "30000€", "50000€"};

    private int currentLevel = 1;

    public MoneyTable() {
    }

    //Decrease level of money by one
    public void decreaseLevel() {
        currentLevel--;
    }

    //Increase level of money  by one
    public void increaseLevel() {
        currentLevel++;
    }

    //get all table with the different values
    public String[] getMoneyLevel() {
        return moneyLevel;
    }

    //get user level
    public String getMoneyLevel(int currentLevel) {
        for (int i = 0; i < moneyLevel.length; i++) {
            if (currentLevel == i) {
                return moneyLevel[i];
            }
        }
        return null;
    }

    //print in different colors the user level from the rest of the other levels
    public void printCurrentLevel(int currentLevel) {
        for (int i = 0; i < moneyLevel.length; i++) {
            if (currentLevel == i) {
                System.out.println(Colors.ANSI_GREEN_BACKGROUND + "[" + moneyLevel[i] + "]" + Colors.ANSI_RESET);
            } else {
                System.out.println(Colors.ANSI_BLUE_BACKGROUND + "[" + moneyLevel[i] + "]" + Colors.ANSI_RESET);
            }
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public String toString() {
        return "Level [" + moneyLevel + "]\n";
    }

}
