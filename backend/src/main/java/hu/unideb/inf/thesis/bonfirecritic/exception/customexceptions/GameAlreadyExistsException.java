package hu.unideb.inf.thesis.bonfirecritic.exception.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class GameAlreadyExistsException extends RuntimeException {
    public GameAlreadyExistsException() {
        super("Provided game already exists");
    }
}
