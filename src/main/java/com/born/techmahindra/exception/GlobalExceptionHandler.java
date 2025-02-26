package com.born.techmahindra.exception;

import com.born.techmahindra.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(createErrorResponse(ex), HttpStatus.BAD_REQUEST);
    }
    public ErrorResponse createErrorResponse(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setSuccess(false);
        errorResponse.setErrorMessage(e.getMessage());
        return errorResponse;
    }

}

