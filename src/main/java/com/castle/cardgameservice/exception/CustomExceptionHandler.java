package com.castle.cardgameservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handles ResponseStatusException thrown by the application.
     *
     * @param ex the ResponseStatusException caught by this handler
     * @return a ResponseEntity containing the exception's reason and the HTTP status code
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getReason(), ex.getStatusCode());
    }

    /**
     * Handles generic exceptions thrown by the application.
     *
     * @param ex the Exception caught by this handler
     * @return a ResponseEntity containing a generic error message and the HTTP status code
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
