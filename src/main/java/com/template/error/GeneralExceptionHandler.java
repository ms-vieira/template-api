package com.template.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionHandler {

    @Autowired
    private ApiExceptionHandler handler;

    /*Error inesperado*/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerInternalServerError(Exception exception, Locale locale) {
        log.error("Error not expected", exception);
        final String errorCode = "error-1";
        final HttpStatus status = INTERNAL_SERVER_ERROR;
        final ErrorResponse errorResponse = ErrorResponse.of(status, handler.toApiError(errorCode, locale));
        return ResponseEntity.status(status).body(errorResponse);
    }
}
