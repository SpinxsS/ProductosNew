package com.nexsy.exception;

public class InvalidCategoryIdException extends RuntimeException {
    public InvalidCategoryIdException() {
        super("Category ID is required and cannot be null");
    }
}
