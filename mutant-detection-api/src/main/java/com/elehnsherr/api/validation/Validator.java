package com.elehnsherr.api.validation;

/**
 * Base interface to add a validation method.
 */
public interface Validator {

    boolean validate(final String[] dna);

}
