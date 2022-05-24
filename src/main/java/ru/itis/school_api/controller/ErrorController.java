package ru.itis.school_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itis.school_api.exception.ErrorEntity;
import ru.itis.school_api.exception.ValidationException;


@ControllerAdvice
public class ErrorController {
    @ExceptionHandler
    public ResponseEntity<ErrorEntity> handle(ValidationException exception) {
        return ResponseEntity
                .status(exception.getEntity().getStatus())
                .body(exception.getEntity());
    }
}
