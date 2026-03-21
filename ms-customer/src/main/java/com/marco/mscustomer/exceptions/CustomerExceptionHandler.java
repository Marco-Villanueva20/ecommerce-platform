package com.marco.mscustomer.exceptions;

import com.marco.exception.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.marco.mscustomer")
public class CustomerExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ProblemDetail handle(CustomerNotFoundException e){
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setProperty("customer", e.getMessage());
        return problem;
    }

}
