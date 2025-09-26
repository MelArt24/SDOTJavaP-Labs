package lab5;

/**
 * Represents a cube toy.
 * Inherits basic properties from {@link Toy}.
 */
public class Cube extends Toy<String> {
    private String color;

    /**
     * Constructs a new Cube.
     * @param name the cube name
     * @param price the cube price
     * @param ageGroup the cube age group
     * @param color the cube color
     * @throws IllegalArgumentException if color is null or empty
     */
    public Cube(String name, double price, String ageGroup, String color) {
        super(name, price, ageGroup);
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Колір не може бути пустим!");
        }
        this.color = color;
    }

    /** @return the cube color */
    public String getColor() { return color; }

    @Override
    public String toString() {
        return super.toString() + ", Color: " + color;
    }
}
