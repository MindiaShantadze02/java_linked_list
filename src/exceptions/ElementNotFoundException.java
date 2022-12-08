package exceptions;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException() {
        super("Element couldn't be found");
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
