package lab5;

/**
 * Generic class that represents a toy.
 * @param <T> the type representing the age group or category of the toy
 */
public class Toy<T> {
    private String name;
    private double price;
    private T ageGroup;

    /**
     * Constructs a new Toy.
     * @param name the toy name
     * @param price the toy price
     * @param ageGroup the toy age group or category
     * @throws IllegalArgumentException if price is negative
     */
    public Toy(String name, double price, T ageGroup) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від’ємною!");
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    /** @return the toy name */
    public String getName() { return name; }

    /** @return the toy price */
    public double getPrice() { return price; }

    /** @return the toy age group */
    public T getAgeGroup() { return ageGroup; }

    @Override
    public String toString() {
        return name + " (" + ageGroup + ") - " + price + " грн";
    }
}
