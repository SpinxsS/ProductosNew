package com.nexsy.exception;

public class ProductCreationException extends RuntimeException {
    public ProductCreationException(String message) {
        super("Error creating product: " + message);
    }
}
