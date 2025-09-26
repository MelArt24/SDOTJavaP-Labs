package lab4;

/**
 * The {@code Punctuation} class represents a punctuation mark.
 *
 * @author MelArt24
 * @version 1.0
 * @since 2025-09-26
 */
public class Punctuation {
    /** The character of the punctuation */
    private char symbol;

    /**
     * Constructor for creating a punctuation mark.
     *
     * @param symbol punctuation mark (, . ! ? etc.)
     */
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
