package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a playroom that stores a collection of toys.
 * Provides methods to add toys, sort them by price, and search by price range.
 */
public class PlayRoom {
    private List<Toy<String>> toys = new ArrayList<>();

    /**
     * Adds a toy to the playroom.
     * @param toy the toy to add
     * @throws NullPointerException if toy is null
     */
    public void addToy(Toy<String> toy) {
        if (toy == null) throw new NullPointerException("Іграшка не може бути null!");
        toys.add(toy);
    }

    /**
     * Sorts toys by price in ascending order.
     */
    public void sortByPrice() {
        toys.sort(Comparator.comparingDouble(Toy::getPrice));
    }

    /**
     * Finds toys that fall within the given price range.
     * @param min the minimum price
     * @param max the maximum price
     * @return list of toys within the price range
     */
    public List<Toy<String>> findByPriceRange(double min, double max) {
        List<Toy<String>> result = new ArrayList<>();
        for (Toy<String> toy : toys) {
            if (toy.getPrice() >= min && toy.getPrice() <= max) result.add(toy);
        }
        return result;
    }

    /**
     * Prints all toys to the console.
     */
    public void showToys() {
        for (Toy<String> toy : toys) {
            System.out.println(toy);
        }
    }
}
