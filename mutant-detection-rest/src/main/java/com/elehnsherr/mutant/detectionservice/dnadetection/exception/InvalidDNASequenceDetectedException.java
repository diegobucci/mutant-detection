package com.elehnsherr.mutant.detectionservice.dnadetection.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Throws to indicate the DNA Sequence has invalid characters or it's not a valid square matrix.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid DNA Sequence")
public class InvalidDNASequenceDetectedException extends RuntimeException {

}
