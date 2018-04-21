package com.elehnsherr.mutant.validation;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DNATableValidatorTest {

    @Autowired
    private DNATableValidator DNATableValidator;

    @Test
    public void validateDNATableWhenIsSquareMatrix(){
        boolean result = DNATableValidator.validate(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        assertTrue(result);
    }

    @Test
    public void validateDNATableWhenIsNotSquareMatrixByRows(){
        boolean result = DNATableValidator.validate(new String[]{"CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        assertFalse(result);
    }

    @Test
    public void validateDNATableWhenIsNotSquareMatrixByColumns(){
        boolean result = DNATableValidator.validate(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACT"});
        assertFalse(result);
    }
}
