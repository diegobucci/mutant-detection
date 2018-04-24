package com.elehnsherr.api.exception;

/**
 * Thrown to indicate that the DNA table is not a valid square Matrix.
 */
public class InvalidDNATableException extends Exception{

    public InvalidDNATableException(){
        super();
    }

    public InvalidDNATableException(String message){
        super(message);
    }
}
