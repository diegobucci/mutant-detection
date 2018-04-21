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
    public void matchMutantInDNASequenceWhenAppearsHorizontally(){
        boolean result = dnaDetectionServiceImpl.isMutant(new String[]{"ATGCGA","CAGTGC","TTATGT","AAAAGG","CCCCTA","TCACTG"});
        assertTrue(result);
    }

    @Test
    public void matchMutantInDNASequenceWhenAppearsVertically(){
        boolean result = dnaDetectionServiceImpl.isMutant(new String[]{"ATGCGC","AAGGCC","ATATGC","AGAAGC","CTATAT","TCACTG"});
        assertTrue(result);
    }
}
