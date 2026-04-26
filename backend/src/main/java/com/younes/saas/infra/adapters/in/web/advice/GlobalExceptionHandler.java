package com.younes.saas.infra.adapters.in.web.advice;

import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleException(
            final ResourceNotFoundException ex,
            final HttpServletRequest request
    ) {

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .code(String.valueOf(NOT_FOUND.value()))
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(
            final MethodArgumentNotValidException ex,
            final HttpServletRequest request
    ) {

        log.warn("Validation failed for request: {}", request.getRequestURI());

        final List<ErrorResponse.ValidationError> errors = new ArrayList<>();
        ex.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    final String fieldName = ((FieldError) error).getField();
                    final String errorCode = error.getCode();
                    final String defaultMessage = error.getDefaultMessage();

                    errors.add(ErrorResponse.ValidationError.builder()
                            .field(fieldName)
                            .code(errorCode)
                            .message(defaultMessage)
                            .build());
                });

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .code(String.valueOf(BAD_REQUEST.value()))
                .message("Validation failed. Please check the requested fields.")
                .path(request.getRequestURI())
                .validationErrors(errors)
                .build();

        return ResponseEntity.status(BAD_REQUEST)
                .body(errorResponse);
    }


}
