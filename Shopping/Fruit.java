package Shopping;

public class Fruit extends Food{
    private String name;
    private double pricePerPound;
    private double weight;

    public Fruit(String name,double pricePerPound,double weight) {
        this.name = name;
        this.pricePerPound = pricePerPound;
        this.weight = weight;
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
