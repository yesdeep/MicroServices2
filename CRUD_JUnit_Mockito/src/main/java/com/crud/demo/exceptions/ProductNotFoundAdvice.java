package com.crud.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ProductNotFoundAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException ex) {
        return ex.getMessage();
    }
}
