package sandBox;

public class EmptyStackAException extends Throwable {
    public EmptyStackAException() {
        super();
    }

    public EmptyStackAException(String message) {
        super(message);
    }

    public EmptyStackAException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStackAException(Throwable cause) {
        super(cause);
    }

    protected EmptyStackAException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
