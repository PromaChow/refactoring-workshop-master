package workshop;

public class GreaterThanTag implements Tags{
    @Override
    public boolean matches(char character) {
        return (character == '>');

    }

    @Override
    public String generate() {
        return "&gt;";
    }
}
