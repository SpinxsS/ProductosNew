package com.nexsy.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(Long long1) {
        super("Product already exists with id: " + long1);
    }
}
