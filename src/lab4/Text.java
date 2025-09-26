package lab4;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences = new ArrayList<>();

    public Text(String rawText) {
        rawText = rawText.replaceAll("[\\s\\t]+", " ").trim();

        String[] parts = rawText.split("(?<=[.!?])");
        for (String p : parts) {
            if (!p.isBlank()) {
                sentences.add(new Sentence(p.trim()));
            }
        }
    }

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
