package com.elehnsherr.api.validation;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class NitrogenBaseCharsSequenceValidator implements Validator {

    private final static String NITROGEN_BASE_CHARS_REGEX = "[ATCG]*";

    @Override
    public boolean validate(String[] dna) {
        Predicate<String> nitrogenBaseChars = seq -> seq.matches(NITROGEN_BASE_CHARS_REGEX);
        List<String> dnaSequence = Arrays.asList(dna);
        return dnaSequence.parallelStream().allMatch(nitrogenBaseChars);
    }
}
