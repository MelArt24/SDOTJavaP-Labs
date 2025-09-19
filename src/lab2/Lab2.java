package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Введіть слова через пробіл (лише літери):");
            StringBuilder inputText = new StringBuilder(scanner.nextLine());

            if (!inputText.toString().matches("[a-zA-Zа-яА-ЯїЇєЄіІґҐ\\s]+")) {
                throw new IllegalArgumentException("Текст повинен містити лише літери та пробіли!");
            }

            System.out.println("Введіть символ для сортування:");
            String charInput = scanner.nextLine();
            if (charInput.length() != 1 || !charInput.matches("[a-zA-Zа-яА-ЯїЇєЄіІґҐ]")) {
                throw new IllegalArgumentException("Потрібно ввести лише одну літеру!");
            }
            char targetChar = charInput.charAt(0);

            List<StringBuilder> words = splitIntoWords(inputText);

            words.sort((w1, w2) -> {
                int count1 = countCharOccurrences(w1, targetChar);
                int count2 = countCharOccurrences(w2, targetChar);

                if (count1 == count2) {
                    return compareStringBuilders(w1, w2);
                }
                return Integer.compare(count1, count2);
            });

            StringBuilder result = new StringBuilder();
            for (StringBuilder word : words) {
                result.append(word).append(" ");
            }

            System.out.println("\nВхідний рядок: " + inputText);
            System.out.println("Відсортовані слова (за кількістю '" + targetChar + "'): " + result.toString().trim());

        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
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

    private static List<StringBuilder> splitIntoWords(StringBuilder text) {
        List<StringBuilder> words = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isWhitespace(c)) {
                if (!current.isEmpty()) {
                    words.add(new StringBuilder(current));
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }
        if (!current.isEmpty()) {
            words.add(current);
        }
        return words;
    }

    private static int compareStringBuilders(StringBuilder sb1, StringBuilder sb2) {
        int len1 = sb1.length();
        int len2 = sb2.length();
        int lim = Math.min(len1, len2);

        for (int i = 0; i < lim; i++) {
            char c1 = sb1.charAt(i);
            char c2 = sb2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return len1 - len2;
    }
}
