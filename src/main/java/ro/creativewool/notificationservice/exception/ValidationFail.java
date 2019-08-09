package ro.creativewool.notificationservice.exception;

public class ValidationFail {

    private final String field;
    private final String message;

    public ValidationFail(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "{" +
                "field=" + field + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}
