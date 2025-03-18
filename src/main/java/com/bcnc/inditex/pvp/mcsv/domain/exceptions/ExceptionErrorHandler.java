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
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "UPS! Bad request, date must have the format yyyy-mm-ddHH:mm:ss. Example: 2020-06-1410:10:00");
        log.error("Unexpected error: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Map<String, Object>> notFound(NotFoundException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", e.getMessage());
        log.error("Not found: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Map<String, Object>> internalServerException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "UPS! Unexpected error, contact system administrator");
        log.error("Unexpected error: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
