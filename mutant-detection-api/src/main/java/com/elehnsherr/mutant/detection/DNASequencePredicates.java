package com.elehnsherr.mutant.detection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DNASequencePredicates {

    public static Predicate<String> isDNAMutantSequence() {
        return p -> p != null && p.matches(".*[A]{4}.*|.*[T]{4}.*|.*[C]{4}.*|.*[G]{4}.*");

    }

    public static List<String> findSequence (List<String> dnaMatrixRows, Predicate<String> predicate) {
        return  dnaMatrixRows.parallelStream().filter(isDNAMutantSequence()).collect(Collectors.toList());
    }

    public static long findSequenceCount (List<String> dnaMatrixRows, Predicate<String> predicate) {
        return  dnaMatrixRows.parallelStream().filter(isDNAMutantSequence()).count();
    }
}
