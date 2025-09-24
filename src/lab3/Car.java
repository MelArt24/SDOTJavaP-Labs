package lab3;

import java.util.Objects;

/**
 * The {@code Car} class represents a car with five main characteristics.
 * <p>
 * This class is used to demonstrate sorting an array of {@code Car} objects
 * by two criteria: first by year of release in ascending order, then by price in descending order.
 * </p>
 *
 * @author MelArt24
 * @version 1.0
 * @since 2025-09-19
 */
public class Car {
    /**
     * Car brand.
     */
    private String brand;

    /**
     * Car model.
     */
    private String model;

    /**
     * Year of release.
     */
    private int year;

    /**
     * Price of the car.
     */
    private double price;

    /**
     * Mileage in kilometers.
     */
    private int mileage;

    /**
     * Constructor for initializing a {@code Car} object with given values.
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

    // --- Getters and setters ---

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
     * @return {@code true}, if the objects are equal; {@code false} otherwise
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
