package lab5;

public class Toy<T> {
    private String name;
    private double price;
    private T ageGroup;

    public Toy(String name, double price, T ageGroup) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від’ємною!");
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getAgeGroup() { return ageGroup; }

    @Override
    public String toString() {
        return name + " (" + ageGroup + ") - " + price + " грн";
    }
}
