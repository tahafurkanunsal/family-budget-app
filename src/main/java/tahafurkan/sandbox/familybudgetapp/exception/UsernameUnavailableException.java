package tahafurkan.sandbox.familybudgetapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class UsernameUnavailableException extends RuntimeException{
    public UsernameUnavailableException(String message) {
        super(message);
    }
}
