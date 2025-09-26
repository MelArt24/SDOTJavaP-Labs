package lab5;

public class Ball extends Toy<String> {
    private double diameter;

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