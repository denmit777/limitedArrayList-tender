package homework8.task1;

public class OverflowingListException extends Exception {

    private String message;

    public OverflowingListException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
