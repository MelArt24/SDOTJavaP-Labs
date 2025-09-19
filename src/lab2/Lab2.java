package lab2;

import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Введіть слова через пробіл:");
            StringBuilder inputText = new StringBuilder(scanner.nextLine());

            System.out.println("Введіть символ для сортування:");
            String charInput = scanner.nextLine();
            if (charInput.length() != 1) {
                throw new IllegalArgumentException("Потрібно ввести лише один символ!");
            }
            char targetChar = charInput.charAt(0);

            String[] words = inputText.toString().split("\\s+");

            Arrays.sort(words, (w1, w2) -> {
                int count1 = countCharOccurrences(new StringBuilder(w1), targetChar);
                int count2 = countCharOccurrences(new StringBuilder(w2), targetChar);

                if (count1 == count2) {
                    return w1.compareToIgnoreCase(w2);
                }
                return Integer.compare(count1, count2);
            });

            StringBuilder result = new StringBuilder();
            for (String word : words) {
                result.append(word).append(" ");
            }

            System.out.println("\nВхідний рядок: " + inputText);
            System.out.println("Відсортовані слова (за кількістю '" + targetChar + "'): " + result.toString().trim());

        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static int countCharOccurrences(StringBuilder text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
