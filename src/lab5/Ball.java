package lab5;

/**
 * Represents a ball.
 * Inherits basic properties from {@link Toy}.
 */
public class Ball extends Toy<String> {
    private double diameter;

    /**
     * Constructs a new Ball.
     * @param name the ball name
     * @param price the ball price
     * @param ageGroup the ball age group
     * @param diameter the ball diameter
     * @throws IllegalArgumentException if diameter is negative
     */
    public Ball(String name, double price, String ageGroup, double diameter) {
        super(name, price, ageGroup);
        if (diameter < 0) {
            throw new IllegalArgumentException("М'яч не може мати діаметр менше 0");
        }
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return super.toString() + ", Diameter: " + diameter;
    }
}