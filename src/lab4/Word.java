package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Word} class represents a word.
 *
 * @author MelArt24
 * @version 1.0
 * @since 2025-09-26
 */
public class Word {
    /** List of letters that make up a word */
    private List<Letter> letters = new ArrayList<>();

    /**
     * A constructor that builds a word from a string.
     *
     * @param text text representation of a word
     */
    public Word(String text) {
        for (char c : text.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * @return text representation of a word
     */
    public String getValue() {
        StringBuilder sb = new StringBuilder();
        for (Letter l : letters) {
            sb.append(l.toString());
        }
        return sb.toString();
    }

    /**
     * Counts the number of occurrences of a given character in a word.
     *
     * @param ch counting symbol
     * @return number of occurrences of a character
     */
    public int countCharOccurrences(char ch) {
        int count = 0;
        for (Letter l : letters) {
            if (l.getValue() == ch) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
