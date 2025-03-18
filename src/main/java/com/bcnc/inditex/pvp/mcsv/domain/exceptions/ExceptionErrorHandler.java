package com.bcnc.inditex.pvp.mcsv.domain.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionErrorHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Map<String, Object>> badRequest(MethodArgumentTypeMismatchException e) {
        log.error("Unexpected error: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildResponse("UPS! Bad request, date must have the format yyyy-mm-ddHH:mm:ss. Example: 2020-06-1410:10:00"));
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Map<String, Object>> notFound(NotFoundException e) {
        log.error("Not found: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildResponse(e.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Map<String, Object>> internalServerException(Exception e) {
        log.error("Unexpected error: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(buildResponse("UPS! Unexpected error, contact system administrator"));
    }

    private Map<String, Object> buildResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", message);
        return response;

    }
}
