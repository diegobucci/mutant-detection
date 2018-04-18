package com.elehnsherr.mutant.detection;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DNADetectionTest {

    @Test
    public void validateDNASequenceWhenIsNull(){
        DNADetection dnaDetection = new DNADetection();
        boolean result = dnaDetection.isMutant(null);

        assertFalse(result);
    }

    @Test
    public void validateDNASequenceWhenThereAreInvalidCharacters(){
        DNADetection dnaDetection = new DNADetection();
        boolean result = dnaDetection.isMutant(new String[]{"AAZZAA", "CAGTGC", "CCCAAA", "TTTTA","XXXXXX","AAAAAAA"});
        assertFalse(result);
    }

    @Test
    public void matchMutantInDNASequenceWhenAppearsHorizontally(){
        DNADetection dnaDetection = new DNADetection();
        boolean result = dnaDetection.isMutant(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        assertTrue(result);
    }

    @Test
    public void matchMutantInDNASequenceWhenAppearsVertically(){
        DNADetection dnaDetection = new DNADetection();
        boolean result = dnaDetection.isMutant(new String[]{"ATGCGA","AAGGC","ATATGT","AGAAGG","CTATAT","TCACTG"});
        assertTrue(result);
    }
}
