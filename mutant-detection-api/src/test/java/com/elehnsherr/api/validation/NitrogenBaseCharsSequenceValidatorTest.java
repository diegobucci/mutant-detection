package com.elehnsherr.api.validation;


import com.elehnsherr.api.validation.NitrogenBaseCharsSequenceValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NitrogenBaseCharsSequenceValidatorTest {

    @Autowired
    private NitrogenBaseCharsSequenceValidator nitrogenBaseCharsSequenceValidator;

    @Test
    public void validateDNASequenceWhenThereAreValidCharacters(){
        boolean result = nitrogenBaseCharsSequenceValidator.validate(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        assertTrue(result);
    }


    @Test
    public void validateDNASequenceWhenThereAreInvalidCharacters(){
        boolean result = nitrogenBaseCharsSequenceValidator.validate(new String[]{"AAZZAA", "CAGTGC", "CCCAAA", "TTTTA","XXXXXX","AAAAAAA"});
        assertFalse(result);
    }
}
