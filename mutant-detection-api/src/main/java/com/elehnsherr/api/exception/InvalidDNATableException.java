package com.elehnsherr.api.exception;

public class InvalidDNATableException extends Exception{

    public InvalidDNATableException(){
        super();
    }

    public InvalidDNATableException(String message){
        super(message);
    }
}
