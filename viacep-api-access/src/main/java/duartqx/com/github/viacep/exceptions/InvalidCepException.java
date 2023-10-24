package duartqx.com.github.viacep.exceptions;

import java.security.InvalidParameterException;

public class InvalidCepException extends InvalidParameterException {
    public InvalidCepException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidCepException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
