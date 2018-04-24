package com.elehnsherr.api.detection;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Util class that organize all the static methods that provides predicates
 */
public class DNASequencePredicates {

    public static final String NITROGEN_CHARS_VALID_SEQUENCE_REGEX = ".*[A]{4}.*|.*[T]{4}.*|.*[C]{4}.*|.*[G]{4}.*";

    private final static String NITROGEN_BASE_CHARS_REGEX = "[ATCG]*";

    /**
     * This checks for repeated specifics DNA characters
     * @return a @{@link Predicate}that test if a valid DNA Sequence appears repeatedly.
     */
    public static Predicate<String> isDNAMutantSequence() {
        return p -> p != null && p.matches(NITROGEN_CHARS_VALID_SEQUENCE_REGEX);

    }

    /**
     * This checks if the characters are a valid nitrogen charactes
     * @return a @{@link Predicate}that test if its a valid Nitrogen DNA Sequence.
     */
    public static Predicate<String> isDNAMutantNitrogenCharacters() {
        return seq -> seq.matches(NITROGEN_BASE_CHARS_REGEX);
    }

    /**
     * Finds a Sequence based on the @{@link Predicate} parameter
     * @param dnaMatrixRows
     * @param predicate
     * @return a @{@link List} with a valid Sequence filtered.
     */
    public static List<String> findSequence (List<String> dnaMatrixRows, Predicate<String> predicate) {
        return  dnaMatrixRows.parallelStream().filter(isDNAMutantSequence()).collect(Collectors.toList());
    }

    /**
     * Counts Sequences filtered based on @{@link Predicate} parameter
     * @param dnaMatrixRows
     * @param predicate
     * @return
     */
    public static long findSequenceCount (List<String> dnaMatrixRows, Predicate<String> predicate) {
        return  dnaMatrixRows.parallelStream().filter(isDNAMutantSequence()).count();
    }
}
