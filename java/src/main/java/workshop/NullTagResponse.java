package workshop;

public class NullTagResponse implements Tags{

    @Override
    public boolean matches(char character) {
        return false;
    }

    @Override
    public String generate() {
        return "";
    }
}
