package com.younes.saas.infra.adapters.in.web.advice;

import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import com.younes.saas.infra.adapters.out.persistence.exceptions.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorResponse> handleException(
            final BusinessException ex,
            final HttpServletRequest request
    ) {
        log.warn("Entity not found", ex);

        final ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        final HttpStatus status = getHttpStatus(ex);

        return ResponseEntity.status(status)
                .body(errorResponse);
    }

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

    private HttpStatus getHttpStatus(final BusinessException ex) {
        if (ex instanceof DuplicateResourceException) {
            return CONFLICT;
        } else if (ex instanceof UnauthorizedException) {
            return UNAUTHORIZED;
        } else if (ex instanceof TenantProvisioningException) {
            return INTERNAL_SERVER_ERROR;
        } else if (ex instanceof InvalidRequestException) {
            return BAD_REQUEST;
        }
        return BAD_REQUEST;
    }

}
