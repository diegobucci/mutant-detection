package com.elehnsherr.api.validation;

import com.elehnsherr.api.detection.DNASequencePredicates;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Validates that the sequence has only nitrogen base chars as a valid characters.
 */
@Component
public class NitrogenBaseCharsSequenceValidator implements Validator {

    @Override
    public boolean validate(String[] dna) {
        List<String> dnaSequence = Arrays.asList(dna);
        return dnaSequence.parallelStream().allMatch(DNASequencePredicates.isDNAMutantNitrogenCharacters());
    }
}
