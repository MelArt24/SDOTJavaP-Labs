package lab5;

/**
 * Represents a toy car.
 * Inherits basic properties from {@link Toy}.
 */
public class Car extends Toy<String> {
    private int speed;

    /**
     * Constructs a new Car.
     * @param name the car name
     * @param price the car price
     * @param ageGroup the car age group
     * @param speed the car maximum speed
     * @throws IllegalArgumentException if speed is negative
     */
    public Car(String name, double price, String ageGroup, int speed) {
        super(name, price, ageGroup);
        if (speed < 0) throw new IllegalArgumentException("Швидкість не може бути від’ємною!");
        this.speed = speed;
    }

    /** @return the car speed */
    public int getSpeed() { return speed; }

    @Override
    public String toString() {
        return super.toString() + ", Speed: " + speed;
    }
}
