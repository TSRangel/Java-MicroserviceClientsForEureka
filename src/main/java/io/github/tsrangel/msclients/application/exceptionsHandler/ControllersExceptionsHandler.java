package io.github.tsrangel.msclients.application.exceptionsHandler;

import io.github.tsrangel.msclients.application.exceptionsHandler.errors.FieldValidationError;
import io.github.tsrangel.msclients.application.exceptionsHandler.errors.StandartError;
import io.github.tsrangel.msclients.application.services.exceptions.ResourceAlreadyExistsException;
import io.github.tsrangel.msclients.application.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ControllersExceptionsHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandartError> standartError(RuntimeException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity.status(status).body(new StandartError(
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        ));
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<StandartError> alreadyExistsError(ResourceAlreadyExistsException e,
                                                                    HttpServletRequest  request) {
        HttpStatus status = HttpStatus.CONFLICT;

        return ResponseEntity.status(status).body(new StandartError(
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        ));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> notFoundError(ResourceNotFoundException e,
                                                                    HttpServletRequest  request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status).body(new StandartError(
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FieldValidationError>  fieldValidatorError(MethodArgumentNotValidException e,
                                                                     HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        HashMap<String, String> errors = new HashMap<>();

        e.getFieldErrors().forEach(fieldError ->
                errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.status(status).body(new FieldValidationError(
                status.value(),
                "Erro de validação de campos.",
                errors
        ));
    }
}
