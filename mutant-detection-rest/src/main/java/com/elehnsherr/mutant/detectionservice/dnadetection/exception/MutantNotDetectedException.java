package com.elehnsherr.mutant.detectionservice.dnadetection.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="No Mutant Detected")
public class MutantNotDetectedException extends RuntimeException {

}
