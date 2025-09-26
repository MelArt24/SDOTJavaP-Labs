package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Text} class represents a text.
 *
 * @author MelArt24
 * @version 1.0
 * @since 2025-09-26
 */
public class Text {
    /** List of sentences that make up the text */
    private List<Sentence> sentences = new ArrayList<>();

    /**
     * A constructor that parses a string into a list of sentences.
     *
     * @param rawText input text
     */
    public Text(String rawText) {
        // replace sequences of spaces/tabs with a single space
        rawText = rawText.replaceAll("[\\s\\t]+", " ").trim();

        // split into sentences by end characters
        String[] parts = rawText.split("(?<=[.!?])");
        for (String p : parts) {
            if (!p.isBlank()) {
                sentences.add(new Sentence(p.trim()));
            }
        }
    }

    /**
     * @return list of sentences of the text
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
