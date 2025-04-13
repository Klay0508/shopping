package Shopping;

public class Vegetable extends Food {
    private String name;
    private double weight;
    private double pricePerPound;

    public Vegetable(String name, double weight, double pricePerPound) {
        this.pricePerPound = pricePerPound;
        this.weight = weight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }
}


