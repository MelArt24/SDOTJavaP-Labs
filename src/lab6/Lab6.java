// My variant - 12
// C2 - 0
// C3 - 0

package lab6;

/**
 * Main class of the application.
 * <p>
 * Demonstrates the usage of the custom {@link ToyList} collection
 * by adding, inserting, and removing {@link Toy} objects.
 */
public class Lab6 {
    public static void main(String[] args) {
        Toy<String> lego = new Toy<>("LEGO Star Wars", 1500, "10+");
        Toy<String> doll = new Toy<>("Barbie", 700, "5+");
        Toy<String> car = new Toy<>("Hot Wheels", 250, "6+");

        ToyList<String> toys = new ToyList<>();
        toys.add(lego);
        toys.add(doll);
        toys.add(0, car);

        System.out.println("Колекція іграшок:");
        System.out.println(toys);

        toys.remove(doll);
        System.out.println("\nПісля видалення однієї іграшки:");
        System.out.println(toys);
    }
}
