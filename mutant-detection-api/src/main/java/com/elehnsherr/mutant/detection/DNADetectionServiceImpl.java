package com.elehnsherr.mutant.detection;

import com.elehnsherr.mutant.exception.InvalidDNATableException;
import com.elehnsherr.mutant.exception.InvalidNitrogenBaseCharsSequenceException;
import com.elehnsherr.mutant.validation.DNATableValidator;
import com.elehnsherr.mutant.validation.NitrogenBaseCharsSequenceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class DNADetectionServiceImpl implements DNADetectionService,MutantDetectionService {

    @Autowired
    public NitrogenBaseCharsSequenceValidator nitrogenBaseCharsSequenceValidator;

    @Autowired
    private DNATableValidator dNATableValidator;

    @Override
    public boolean isMutantDetected(String[] dna)
            throws InvalidNitrogenBaseCharsSequenceException, InvalidDNATableException {
        validateDNA(dna);
        return isMutant(dna);
    }

    private void validateDNA(final String[] dna)
            throws InvalidNitrogenBaseCharsSequenceException, InvalidDNATableException {
        if (!nitrogenBaseCharsSequenceValidator.validate(dna)) {
            throw new InvalidNitrogenBaseCharsSequenceException("There is an invalid char in DNA sequence");
        }

        if (!dNATableValidator.validate(dna)) {
            throw new InvalidDNATableException("Invalid DNA Square Table");
        }
    }

    @Override
    public boolean isMutant(final String[] dna){
        if (dna == null)
            return false;

        List<String> dnaMatrixRows = Arrays.asList(dna);

        List mutantSequences = DNASequencePredicates.findSequence(dnaMatrixRows,DNASequencePredicates.isDNAMutantSequence());
        if(mutantSequences.size()>1)
            return true;

        List<char[]> dnaCharsList = new ArrayList<>();
        for (String dnaSequence:dnaMatrixRows){
            char[] dnaSequenceToCHar = dnaSequence.toCharArray();
            dnaCharsList.add(dnaSequenceToCHar);
        }

        String[] newDnaMatrixRows = new String[dnaCharsList.get(0).length];
        for (int i = 0; i < dnaCharsList.get(0).length; i++) {
            newDnaMatrixRows[i] = "";
            for (char[] dnaChars : dnaCharsList){
                newDnaMatrixRows[i] = newDnaMatrixRows[i].concat(String.valueOf(dnaChars[i]));
            }
        }

        dnaMatrixRows = Arrays.asList(newDnaMatrixRows);
        List mutantSequencesVertically = DNASequencePredicates.findSequence(dnaMatrixRows,DNASequencePredicates.isDNAMutantSequence());
        mutantSequencesVertically.forEach(dnaS->System.out.println(dnaS));
        if(mutantSequencesVertically.size()>1)
            return true;

        return false;
    }




}
