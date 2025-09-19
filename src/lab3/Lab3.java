package lab3;

import java.util.Arrays;
import java.util.Objects;

/**
 * Клас <code>Car</code> представляє автомобіль з п’ятьма основними характеристиками.
 * <p>
 * Цей клас використовується для демонстрації сортування масиву об'єктів <code>Car</code>
 * за двома критеріями: спочатку за роком випуску за зростанням, потім за ціною за спаданням.
 * </p>
 *
 * @author MelArt24
 * @version 1.0
 * @since 2025-09-19
 */
class Car {
    // Поля класу
    private String brand;       /**< Марка автомобіля */
    private String model;       /**< Модель автомобіля */
    private int year;           /**< Рік випуску */
    private double price;       /**< Ціна */
    private int mileage;        /**< Пробіг в кілометрах */

    /**
     * Конструктор для ініціалізації об'єкта <code>Car</code> з заданими значеннями.
     *
     * @param brand   марка автомобіля
     * @param model   модель автомобіля
     * @param year    рік випуску
     * @param price   ціна
     * @param mileage пробіг
     */
    public Car(String brand, String model, int year, double price, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

    // Геттери та сеттери

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
     * Повертає рядкове представлення цього об'єкта.
     *
     * @return рядкове представлення
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
     * Порівнює цей об'єкт з іншим.
     *
     * @param o об'єкт для порівняння
     * @return <code>true</code>, якщо об'єкти рівні; <code>false</code> в іншому випадку
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
     * Генерує хеш-код для цього об'єкта.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, price, mileage);
    }
}

/**
 * Головний клас програми, що демонструє сортування та пошук об'єктів <code>Car</code>.
 */
public class Lab3 {
    /**
     * Головний метод програми.
     * <p>
     * Створює масив об'єктів <code>Car</code>, сортує їх за двома критеріями та шукає заданий об'єкт.
     * </p>
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        // Створення масиву об'єктів Car
        Car[] cars = {
                new Car("Toyota", "Corolla", 2018, 15000, 50000),
                new Car("Honda", "Civic", 2020, 20000, 30000),
                new Car("Ford", "Focus", 2018, 18000, 40000),
                new Car("Toyota", "Camry", 2019, 22000, 35000),
                new Car("Honda", "Accord", 2018, 25000, 25000)
        };

        // Сортування масиву: спочатку за роком (year) за зростанням,
        // якщо роки однакові — за ціною (price) за спаданням
        Arrays.sort(cars, (c1, c2) -> {
            int yearCompare = Integer.compare(c1.getYear(), c2.getYear());
            if (yearCompare != 0) {
                return yearCompare; // за зростанням року
            } else {
                return -Double.compare(c1.getPrice(), c2.getPrice()); // за спаданням ціни
            }
        });

        // Вивід відсортованого масиву
        System.out.println("Відсортований масив автомобілів:");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Пошук конкретного автомобіля (об'єкта) в масиві
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
