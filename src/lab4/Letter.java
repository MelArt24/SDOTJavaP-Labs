package lab4;

public class Letter {
    private char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void toUpperCase() {
        value = Character.toUpperCase(value);
    }

    public void toLowerCase() {
        value = Character.toLowerCase(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
