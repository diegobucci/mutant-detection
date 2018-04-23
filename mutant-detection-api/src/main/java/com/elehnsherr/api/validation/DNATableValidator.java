package com.elehnsherr.api.validation;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DNATableValidator implements Validator {

    @Override
    public boolean validate(String[] dna) {
        List<String> dnaSequence = Arrays.asList(dna);
        if(dnaSequence.size()>0){
            return dnaSequence.parallelStream().noneMatch(d -> d.length()!= dnaSequence.size());
        }
        return false;
    }
}
