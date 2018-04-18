package com.elehnsherr.mutant.detection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DNADetection implements MutantDetectionService {

    @Override
    public boolean isMutant(final String[] dna) {
        if (dna == null)
            return false;

        if (!validateSequenceCharacters(dna))
            return false;

        return true;
    }

    private boolean validateSequenceCharacters(String[] dna) {
        Predicate<String> nitrogenBaseChars = seq -> seq.matches("[ATCG]*");
        List<String> dnaSequence = Arrays.asList(dna);
        return dnaSequence.parallelStream().allMatch(nitrogenBaseChars);
    }
}
