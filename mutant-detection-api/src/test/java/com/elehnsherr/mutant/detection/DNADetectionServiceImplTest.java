package com.elehnsherr.mutant.detection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DNADetectionServiceImplTest {

    @Autowired
    private DNADetectionServiceImpl dnaDetectionServiceImpl;

    @Test
    public void matchMutantInDNASequenceWhenIsNull(){
        boolean result = dnaDetectionServiceImpl.isMutant(null);
        assertFalse(result);
    }

    @Test
    public void matchMutantInDNASequenceWhenOnlyAppearsHorizontally(){
        boolean result = dnaDetectionServiceImpl.isMutant(new String[]{"ATGCGA","CAGTGC","TTATGT","GAAAAG","ACCCCT","TCACTG"});
        assertTrue(result);
    }

    @Test
    public void noMatchMutantInDNASequenceWhenOnlyAppearsOneHorizontally(){
        boolean result = dnaDetectionServiceImpl.isMutant(new String[]{"ATGCGA","CAGTGC","TTATGT","GAATAG","ACCCCT","TCACTG"});
        assertFalse(result);
    }

    @Test
    public void matchMutantInDNASequenceWhenOnlyAppearsVertically(){
        boolean result = dnaDetectionServiceImpl.isMutant(new String[]{"ATGCGC","AAGGCC","ATATGC","AGAAGC","CTATAT","TCACTG"});
        assertTrue(result);
    }

    @Test
    public void matchMutantInDNASequenceWhenOnlyAppearsDiagonally(){
        boolean result = dnaDetectionServiceImpl.isMutant(new String[]{"ATCTGC","TCTGAG","CACTCA","TGTCTC","CACGAC","ACTGTG"});
        assertTrue(result);
    }

    @Test
    public void matchMutantInDNASequenceWhenAppearsHorizontallyAndVertically(){
        boolean result = dnaDetectionServiceImpl.isMutant(new String[]{"ATGCGA","CAGTGC","TTATGC","GAAAAC","AGTATC","TCACTG"});
        assertTrue(result);
    }

    @Test
    public void matchMutantInDNASequenceWhenAppearsHorizontallyAndDiagonally(){
        boolean result = dnaDetectionServiceImpl.isMutant(new String[]{"AAAAGA","CAGTGT","TTGTGC","GAAGAC","AGTAGC","TCACTG"});
        assertTrue(result);
    }

}
