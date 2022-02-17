package workshop;

public class LineBreak implements Tags{
    @Override
    public boolean matches(char character) {
        return (character == '\n');

    }

    @Override
    public String generate() {
        return "";
    }
}
