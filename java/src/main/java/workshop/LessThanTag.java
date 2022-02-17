package workshop;

public class LessThanTag implements Tags {
    @Override
    public boolean matches(char character) {
        return (character == '<');

    }

    @Override
    public String generate() {
        return "&lt;";
    }
}
