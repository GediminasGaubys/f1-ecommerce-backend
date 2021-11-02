package com.commerce.f1shop.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoesNotExistException extends RuntimeException{
    public DoesNotExistException(long itemId) {
        super("Item " + itemId + " does not exist.");
    }
}
