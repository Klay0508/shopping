package Shopping;

public class Bread extends Food {
    private String name;
    private double price;

    public Bread(String name,double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bread type: " + name + "\nPrice: $" + price;
    }
}
