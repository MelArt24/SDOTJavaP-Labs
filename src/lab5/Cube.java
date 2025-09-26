package lab5;

public class Cube extends Toy<String> {
    private String color;

    public Cube(String name, double price, String ageGroup, String color) {
        super(name, price, ageGroup);
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Колір не може бути пустим!");
        }
        this.color = color;
    }

    public String getColor() { return color; }

    @Override
    public String toString() {
        return super.toString() + ", Color: " + color;
    }
}
