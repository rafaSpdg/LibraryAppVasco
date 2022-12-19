public class NotEnoughPermissionException extends Exception {
    public NotEnoughPermissionException() {
        super();
    }

    public NotEnoughPermissionException(String message) {
        super(message);
    }

    public NotEnoughPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughPermissionException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughPermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
