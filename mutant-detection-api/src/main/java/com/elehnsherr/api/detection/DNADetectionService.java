package com.elehnsherr.api.detection;

import com.elehnsherr.api.exception.InvalidNitrogenBaseCharsSequenceException;
import com.elehnsherr.api.exception.InvalidDNATableException;

/**
 * Service to to expose a method that validates the DNA Sequence Matrix and detect if it is a Mutant DNA.
 */
public interface DNADetectionService extends MutantDetectionService {

    /**
     * Returns true if the DNA Sequence belongs to Mutant DNA.
     * This method is a wrapper of the {@link MutantDetectionService} adding validations
     * @param dna an Array of Strings that represents a valid DNA Sequence
     * @return true if it is Mutant
     * @throws InvalidNitrogenBaseCharsSequenceException
     * @throws InvalidDNATableException
     */
    public boolean isMutantDetected(String[] dna)
            throws InvalidNitrogenBaseCharsSequenceException, InvalidDNATableException;

}
