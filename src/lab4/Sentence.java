package lab4;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Object> elements = new ArrayList<>();

    public Sentence(String text) {
        StringBuilder currentWord = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c) || c == '\'') {
                currentWord.append(c);
            } else if (c == ' ') {
                if (!currentWord.isEmpty()) {
                    elements.add(new Word(currentWord.toString()));
                    currentWord.setLength(0);
                }
            } else if (c == ',' || c == '.' || c == '!' || c == '?') {
                if (!currentWord.isEmpty()) {
                    elements.add(new Word(currentWord.toString()));
                    currentWord.setLength(0);
                }
                elements.add(new Punctuation(c));
            }
        }

        if (!currentWord.isEmpty()) {
            elements.add(new Word(currentWord.toString()));
        }
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object e : elements) {
            if (e instanceof Word w) {
                words.add(w);
            }
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            Object e = elements.get(i);

            if (e instanceof Word) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(e.toString());
            } else if (e instanceof Punctuation) {
                sb.append(e.toString());
            }
        }
        return sb.toString();
    }

}
