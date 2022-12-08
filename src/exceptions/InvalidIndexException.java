package exceptions;

public class InvalidIndexException extends Exception{
    public InvalidIndexException() {
        super("Couldn't find element with provided index");
    }

    public InvalidIndexException(String message) {
        super(message);
    }
}
