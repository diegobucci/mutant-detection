package com.elehnsherr.api.detection;

import com.elehnsherr.api.exception.InvalidNitrogenBaseCharsSequenceException;
import com.elehnsherr.api.exception.InvalidDNATableException;

public interface DNADetectionService extends MutantDetectionService{

    public boolean isMutantDetected(String[] dna) throws InvalidNitrogenBaseCharsSequenceException,InvalidDNATableException;

}
