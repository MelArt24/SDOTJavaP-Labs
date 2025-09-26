package lab4;

/**
 * The {@code Letter} class represents a single letter.
 *
 * @author MelArt24
 * @version 1.0
 * @since 2025-09-26
 */
public class Letter {
    /** The character of the letter */
    private char value;

    /**
     * Constructor for creating a letter.
     *
     * @param value the character representing the letter
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * @return character-value of the letter
     */
    public char getValue() {
        return value;
    }

    /** Converts a letter to uppercase */
    public void toUpperCase() {
        value = Character.toUpperCase(value);
    }

    /** Converts a letter to lowercase */
    public void toLowerCase() {
        value = Character.toLowerCase(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
