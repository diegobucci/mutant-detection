package com.elehnsherr.mutant.detectionservice.dnadetection;

import com.elehnsherr.api.exception.InvalidDNATableException;
import com.elehnsherr.api.exception.InvalidNitrogenBaseCharsSequenceException;

import java.util.List;
import java.util.Optional;

public interface DetectionService {

    DNASequence verifyDNASequence(final DNASequence dnaSequence)
            throws InvalidNitrogenBaseCharsSequenceException, InvalidDNATableException;

}
