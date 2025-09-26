package lab5;

public class Car extends Toy<String> {
    private int speed;

    public Car(String name, double price, String ageGroup, int speed) {
        super(name, price, ageGroup);
        if (speed < 0) throw new IllegalArgumentException("Швидкість не може бути від’ємною!");
        this.speed = speed;
    }

    public int getSpeed() { return speed; }

    @Override
    public String toString() {
        return super.toString() + ", Speed: " + speed;
    }
}
