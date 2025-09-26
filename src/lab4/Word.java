package lab4;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Letter> letters = new ArrayList<>();

    public Word(String text) {
        for (char c : text.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    public String getValue() {
        StringBuilder sb = new StringBuilder();
        for (Letter l : letters) {
            sb.append(l.toString());
        }
        return sb.toString();
    }

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
