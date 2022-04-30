package homework8.task2;

public class UnsuitableArgumentException extends Exception {

    private String message;

    public UnsuitableArgumentException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
