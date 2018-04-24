package com.elehnsherr.api.exception;

/**
 * Thrown to indicate that the DNA Sequence has invalid characters.
 */
public class InvalidNitrogenBaseCharsSequenceException extends Exception{

    public InvalidNitrogenBaseCharsSequenceException(){
        super();
    }

    public InvalidNitrogenBaseCharsSequenceException(String message){
        super(message);
    }
}
