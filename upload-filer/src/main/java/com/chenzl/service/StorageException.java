package com.chenzl.service;

/**
 * Created by chenzl on 2017/12/7.
 */
public class StorageException extends RuntimeException{
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
