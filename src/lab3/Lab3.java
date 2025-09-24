package lab3;

import java.util.Arrays;
import java.util.Objects;

/**
 * The <code>Car</code> class represents a car with five main characteristics.
 * <p>
 * This class is used to demonstrate sorting an array of <code>Car</code> objects
 * by two criteria: first by year of release in ascending order, then by price in descending order.
 * </p>
 *
 * @author MelArt24
 * @version 1.0
 * @since 2025-09-19
 */
class Car {
    // Поля класу
    private String brand;       /**< Car brand */
    private String model;       /**< Car model */
    private int year;           /**< Year of release */
    private double price;       /**< Price */
    private int mileage;        /**< Mileage in kilometers */

    /**
     * Constructor for initializing a <code>Car</code> object with given values.
     *
     * @param brand   car brand
     * @param model   car model
     * @param year    year of manufacture
     * @param price   price
     * @param mileage mileage
     */
    public Car(String brand, String model, int year, double price, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

    // getters and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", mileage=" + mileage +
                '}';
    }

    /**
     * Compares this object with another one.
     *
     * @param o object for comparison
     * @return <code>true</code>, if the objects are equal; <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return year == car.year &&
                Double.compare(car.price, price) == 0 &&
                mileage == car.mileage &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    /**
     * Generates a hash code for this object.
     *
     * @return a hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, price, mileage);
    }
}

/**
 * The main class of the program demonstrating sorting and searching for <code>Car</code> objects.
 */
public class Lab3 {
    /**
     * The main method of the program.
     * <p>
     * Creates an array of objects <code>Car</code>, sorts them by two criteria and searches for the specified object.
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
        // if the years are equal — by price in descending order
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
