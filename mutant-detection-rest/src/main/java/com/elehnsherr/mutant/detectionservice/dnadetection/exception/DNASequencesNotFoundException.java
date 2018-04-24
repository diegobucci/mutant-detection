package com.elehnsherr.mutant.detectionservice.dnadetection.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class DNASequencesNotFoundException extends RuntimeException {
    public DNASequencesNotFoundException(String message) {
        super(message);
    }
}
