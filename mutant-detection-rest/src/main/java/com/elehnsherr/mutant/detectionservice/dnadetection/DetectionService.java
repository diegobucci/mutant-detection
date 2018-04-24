package com.elehnsherr.mutant.detectionservice.dnadetection;

import com.elehnsherr.api.exception.InvalidDNATableException;
import com.elehnsherr.api.exception.InvalidNitrogenBaseCharsSequenceException;

public interface DetectionService {

    DNASequence verifyDNASequence(final DNASequence dnaSequence)
            throws InvalidNitrogenBaseCharsSequenceException, InvalidDNATableException;

}
