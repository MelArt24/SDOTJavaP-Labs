package lab5;

/**
 * Represents a doll.
 * Inherits basic properties from {@link Toy}.
 */
public class Doll extends Toy<String> {
    private String material;

    /**
     * Constructs a new Doll.
     * @param name the doll name
     * @param price the doll price
     * @param ageGroup the doll age group
     * @param material the doll material
     * @throws IllegalArgumentException if material is null or empty
     */
    public Doll(String name, double price, String ageGroup, String material) {
        super(name, price, ageGroup);
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("Лялька повинна бути створена з якогось матеріалу.");
        }
        this.material = material;
    }

    public String getMaterial() { return material; }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
}
