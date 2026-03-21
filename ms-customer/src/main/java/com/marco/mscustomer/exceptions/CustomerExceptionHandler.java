package com.marco.mscustomer.exceptions;

import com.marco.exception.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.marco.mscustomer")
public class CustomerExceptionHandler extends GlobalExceptionHandler {
}
