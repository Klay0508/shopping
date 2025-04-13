package Shopping;

public class Food{
    private Fruit fruits;
    private Vegetable vegetable;
    private Dairy dairy;
    private Bread bread;
    private Snacks snacks;

    public Food(Fruit fruits, Vegetable vegetable, Dairy dairy, Bread bread, Snacks snacks) {
        this.fruits = fruits;
        this.vegetable = vegetable;
        this.dairy = dairy;
        this.bread = bread;
        this.snacks = snacks;
    }

    public Food() {
    }

    public Fruit getFruits() {
        return fruits;
    }

    public void setFruits(Fruit fruits) {
        this.fruits = fruits;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public Dairy getDairy() {
        return dairy;
    }

    public void setDairy(Dairy dairy) {
        this.dairy = dairy;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public Snacks getSnacks() {
        return snacks;
    }

    public void setSnacks(Snacks snacks) {
        this.snacks = snacks;
    }
}
