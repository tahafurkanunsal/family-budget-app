package tahafurkan.sandbox.familybudgetapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchUserExistsException extends RuntimeException{
    public NoSuchUserExistsException(String message) {
        super(message);
    }
}
