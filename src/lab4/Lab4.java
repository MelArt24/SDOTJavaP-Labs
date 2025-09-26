package lab4;

import java.util.*;

/**
 * The main class of the program.
 * Reads text, performs validation, builds the structure of the text
 * (sentences, words, letters, punctuation marks), and then sorts the words
 * by the number of occurrences of the given letter.
 */
public class Lab4 {
    /**
     * The main method of the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введіть слова через пробіл (лише літери):");
            String input = scanner.nextLine();

            if (!input.matches("[a-zA-Zа-яА-ЯїЇєЄіІґҐ\\s,.!?']+")) {
                throw new IllegalArgumentException(
                        "Текст повинен містити лише літери, пробіли та розділові знаки (, . ! ? ')"
                );
            }

            Text text = new Text(input);

            System.out.println("Введіть символ для сортування:");
            String charInput = scanner.nextLine();
            if (charInput.length() != 1 || !charInput.matches("[a-zA-Zа-яА-ЯїЇєЄіІґҐ]")) {
                throw new IllegalArgumentException("Потрібно ввести лише одну літеру!");
            }
            char targetChar = charInput.charAt(0);

            List<Word> allWords = new ArrayList<>();
            for (Sentence s : text.getSentences()) {
                allWords.addAll(s.getWords());
            }

            allWords.sort((w1, w2) -> {
                int count1 = w1.countCharOccurrences(targetChar);
                int count2 = w2.countCharOccurrences(targetChar);

                if (count1 == count2) {
                    return w1.getValue().compareTo(w2.getValue());
                }
                return Integer.compare(count1, count2);
            });

            System.out.println("\nВхідний текст: " + text);
            System.out.println("Відсортовані слова (за кількістю '" + targetChar + "'): ");
            allWords.forEach(w -> System.out.print(w + " "));
        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
        }
    }
}
