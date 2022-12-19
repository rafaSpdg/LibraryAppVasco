package quizGame;

public class PositionMoney {
    private String money;
    private boolean position = false;

    public PositionMoney(String money) {
        this.money = money;
    }

    public PositionMoney(String money, boolean position) {
        this.money = money;
        this.position = position;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public boolean isPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }
}
