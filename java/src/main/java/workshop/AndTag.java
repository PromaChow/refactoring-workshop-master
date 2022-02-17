package workshop;

public class AndTag implements Tags{
    @Override
    public boolean matches(char character) {
        return (character == '&');

    }

    @Override
    public String generate() {
        return "&amp;";
    }
}
