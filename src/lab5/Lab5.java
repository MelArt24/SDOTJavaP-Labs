package lab5;

/**
 * Entry point of the application.
 * Demonstrates adding, sorting, and searching toys in the playroom.
 */
public class Lab5 {
    public static void main(String[] args) {
        PlayRoom room = new PlayRoom();

        room.addToy(new Car("Маленька машинка", 150, "маленькі", 10));
        room.addToy(new Doll("Лялька Барбі", 300, "середні", "пластик"));
        room.addToy(new Ball("Футбольний м’яч", 200, "великі", 22));
        room.addToy(new Cube("Класичний кубик", 50, "маленькі", "червоний"));

        System.out.println("Усі іграшки:");
        room.showToys();

        room.sortByPrice();
        System.out.println("\nІграшки після сортування за ціною:");
        room.showToys();

        System.out.println("\nІграшки в діапазоні 150-250 грн:");
        for (Toy<String> toy : room.findByPriceRange(150, 250)) {
            System.out.println(toy);
        }
    }
}
