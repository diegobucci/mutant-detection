package com.elehnsherr.mutant.detectionservice.dnadetection;

import com.elehnsherr.api.detection.DNADetectionService;
import com.elehnsherr.api.exception.InvalidDNATableException;
import com.elehnsherr.api.exception.InvalidNitrogenBaseCharsSequenceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DetectionServiceImplTest{

    @Mock
    private DetectionRepository detectionRepository;

    @Mock
    private DNADetectionService dnaDetectionService;

    @InjectMocks
    private DetectionServiceImpl detectionService;


    @Before
    public void initialize() {
        detectionService = new DetectionServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyDNASequenceWhenMutantIsFound() throws InvalidNitrogenBaseCharsSequenceException
            ,InvalidDNATableException{

        // Arrange
        DNASequence dnaSequence = new DNASequence();
        when(dnaDetectionService.isMutantDetected(dnaSequence.getDna())).thenReturn(true);

        // Act
        detectionService.verifyDNASequence(dnaSequence);

        // Assert
        assertTrue(dnaSequence.isMutant());
    }

    @Test
    public void verifyDNASequenceIsSaved() throws InvalidNitrogenBaseCharsSequenceException
            ,InvalidDNATableException{

        // Arrange
        DNASequence dnaSequence = new DNASequence();
        when(dnaDetectionService.isMutantDetected(dnaSequence.getDna())).thenReturn(true);

        // Act
        detectionService.verifyDNASequence(dnaSequence);

        // Assert
        verify(detectionRepository,times(1)).save(dnaSequence);
    }

}
