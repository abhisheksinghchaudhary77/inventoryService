package com.ecom.inventoryService.inventoryService.exceptionHandling.customException;

public class ProductDoesNotExistException extends RuntimeException{

    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
