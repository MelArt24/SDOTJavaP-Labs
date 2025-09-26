package lab5;

public class Doll extends Toy<String> {
    private String material;

    public Doll(String name, double price, String ageGroup, String material) {
        super(name, price, ageGroup);
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("Лялька повинна бути створена з якогось матеріалу.");
        }
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
}
