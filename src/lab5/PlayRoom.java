package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayRoom {
    private List<Toy<String>> toys = new ArrayList<>();

    public void addToy(Toy<String> toy) {
        if (toy == null) throw new NullPointerException("Іграшка не може бути null!");
        toys.add(toy);
    }

    public void sortByPrice() {
        toys.sort(Comparator.comparingDouble(Toy::getPrice));
    }

    public List<Toy<String>> findByPriceRange(double min, double max) {
        List<Toy<String>> result = new ArrayList<>();
        for (Toy<String> toy : toys) {
            if (toy.getPrice() >= min && toy.getPrice() <= max) result.add(toy);
        }
        return result;
    }

    public void showToys() {
        for (Toy<String> toy : toys) {
            System.out.println(toy);
        }
    }
}
