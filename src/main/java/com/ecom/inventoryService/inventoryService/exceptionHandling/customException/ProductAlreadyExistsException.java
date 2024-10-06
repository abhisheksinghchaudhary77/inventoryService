package com.ecom.inventoryService.inventoryService.exceptionHandling.customException;


public class ProductAlreadyExistsException extends RuntimeException{

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
