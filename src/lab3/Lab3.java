package lab3;

import java.util.Arrays;

/**
 * The main class of the program demonstrating sorting and searching for {@code Car} objects.
 */
public class Lab3 {
    /**
     * The main method of the program.
     * <p>
     * Creates an array of objects {@code Car}, sorts them by two criteria and searches for the specified object.
     * </p>
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating an array of Car objects
        Car[] cars = {
                new Car("Toyota", "Corolla", 2018, 15000, 50000),
                new Car("Honda", "Civic", 2020, 20000, 30000),
                new Car("Ford", "Focus", 2018, 18000, 40000),
                new Car("Toyota", "Camry", 2019, 22000, 35000),
                new Car("Honda", "Accord", 2018, 25000, 25000)
        };

        // Sort the array: first by year in ascending order,
        // if the years are equal (the same) — by price in descending order
        Arrays.sort(cars, (c1, c2) -> {
            int yearCompare = Integer.compare(c1.getYear(), c2.getYear());
            if (yearCompare != 0) {
                return yearCompare; // in ascending order of year
            } else {
                return -Double.compare(c1.getPrice(), c2.getPrice()); // in descending order of price
            }
        });

        // Output the sorted array
        System.out.println("Sorted array of cars:");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Searching for a specific car (object) in an array
        Car searchCar = new Car("Ford", "Focus", 2018, 18000, 40000);
        boolean found = false;
        for (Car car : cars) {
            if (car.equals(searchCar)) {
                found = true;
                System.out.println("\nObject found: " + car);
                break;
            }
        }
        if (!found) {
            System.out.println("\nObject not found in array.");
        }
    }
}
