package items;

public class Gold implements Comparable<Gold>, Item {
    private final String name = "Gold";
    private int amount;
    //TODO check if this thread safe.


    public Gold(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public synchronized void  setAmount(int amount) {
        this.amount = amount;
    }

    public synchronized void decreaseGold(Gold gold) {
        if (this.amount > gold.amount)
            this.amount = this.amount - gold.amount;
    }

    public synchronized void increaseGold(Gold gold) {
        if (gold.amount >= 0)
            this.amount = this.amount + gold.amount;
    }

    public synchronized Gold divideGold(int divideBy) {
        int amount = getAmount();
        if (amount == 0)
            return new Gold(0);
        if (this.getAmount() > 0)
            return new Gold(this.getAmount() / divideBy);
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return amount + name;
    }

    @Override
    public Gold getPrice() {
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Gold o) {
        if (this.getAmount() > o.getAmount()) return 1;
        else if (this.getAmount() == o.getAmount()) return 0;
        return -1;
    }


}
