package io.github.tsrangel.msclients.application.exceptionsHandler.errors;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.HashMap;

public record FieldValidationError(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss'Z'", timezone = "GMT-3")
    Instant timestamp,
    Integer status,
    String message,
    HashMap<String, String> errors
) {
    public FieldValidationError(Integer status, String message, HashMap<String, String> errors) {
        this(Instant.now(), status, message, errors);
    }
}
