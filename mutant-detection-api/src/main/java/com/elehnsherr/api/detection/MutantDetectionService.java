package com.elehnsherr.api.detection;

public interface MutantDetectionService {

    boolean isMutant(final String[] dna) throws Exception;
}
