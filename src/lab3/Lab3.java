package lab3;

import java.util.Arrays;
import java.util.Objects;

class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private int mileage;

    public Car(String brand, String model, int year, double price, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, price, mileage);
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Car[] cars = {
                new Car("Toyota", "Corolla", 2018, 15000, 50000),
                new Car("Honda", "Civic", 2020, 20000, 30000),
                new Car("Ford", "Focus", 2018, 18000, 40000),
                new Car("Toyota", "Camry", 2019, 22000, 35000),
                new Car("Honda", "Accord", 2018, 25000, 25000)
        };

        Arrays.sort(cars, (c1, c2) -> {
            int yearCompare = Integer.compare(c1.getYear(), c2.getYear());
            if (yearCompare != 0) {
                return yearCompare;
            } else {
                return -Double.compare(c1.getPrice(), c2.getPrice());
            }
        });

        System.out.println("Відсортований масив автомобілів:");
        for (Car car : cars) {
            System.out.println(car);
        }

        Car searchCar = new Car("Ford", "Focus", 2018, 18000, 40000);
        boolean found = false;
        for (Car car : cars) {
            if (car.equals(searchCar)) {
                found = true;
                System.out.println("\nЗнайдено об’єкт: " + car);
                break;
            }
        }
        if (!found) {
            System.out.println("\nОб’єкт не знайдено в масиві.");
        }
    }
}
