package items;

public class Gold extends Item implements Comparable<Gold> {
    private String name = "Gold";
    private int amount;
    //TODO check if this thread safe.

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Gold(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
