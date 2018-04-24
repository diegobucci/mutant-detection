package com.elehnsherr.api.detection;

/**
 * This root interface is used to detect if it's a Mutant DNA Sequence
 */
public interface MutantDetectionService {

    /**
     * This validates DNA Sequence that belongs to Mutant DNA
     * @param dna
     * @return true if it's a mutant DNA
     * @throws Exception
     */
    boolean isMutant(final String[] dna) throws Exception;
}
