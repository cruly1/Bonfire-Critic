package hu.unideb.inf.thesis.bonfirecritic.exception;

import hu.unideb.inf.thesis.bonfirecritic.exception.customexceptions.GameAlreadyExistsException;
import hu.unideb.inf.thesis.bonfirecritic.exception.customexceptions.GameNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGameNotFoundException(GameNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        log.error("Error {}", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleGameAlreadyExistsException(GameAlreadyExistsException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        log.error("Error {}", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
