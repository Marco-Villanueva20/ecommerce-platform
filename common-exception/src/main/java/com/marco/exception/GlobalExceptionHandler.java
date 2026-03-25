package com.marco.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception e){
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problem.setTitle("Server Error");

        problem.setDetail("An unexpected error occurred. Please provide this Trace ID to support: {id}");
        // String traceId = Span.current().context().traceId();
        // problem.setProperty("trace_id", traceId);
        log.error("Error: ", e);
        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleException(MethodArgumentNotValidException e){
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Error de validación");
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

       problem.setProperty("errors", errors);
       log.warn("Validation error: {}, Total: {}", errors.keySet(), errors.size());
       return problem;
    }

}
