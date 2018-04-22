package com.elehnsherr.mutant.detection;

import com.elehnsherr.mutant.exception.InvalidDNATableException;
import com.elehnsherr.mutant.exception.InvalidNitrogenBaseCharsSequenceException;

public interface DNADetectionService extends MutantDetectionService{

    public boolean isMutantDetected(String[] dna) throws InvalidNitrogenBaseCharsSequenceException,InvalidDNATableException;

}
