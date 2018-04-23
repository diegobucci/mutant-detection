package com.elehnsherr.mutant.detectionservice.dnadetection.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid DNA Sequence")
public class InvalidDNASequenceDetectedException extends RuntimeException {

}
