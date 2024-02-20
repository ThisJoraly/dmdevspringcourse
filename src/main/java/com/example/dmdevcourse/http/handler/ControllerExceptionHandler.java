package com.example.dmdevcourse.http.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String handleExceptions(Exception exception, HttpServletRequest request) {
        log.error("failed to return response", exception);
        return "error/error500";
    }
}
