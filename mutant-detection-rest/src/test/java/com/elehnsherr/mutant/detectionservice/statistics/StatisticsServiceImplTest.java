package com.elehnsherr.mutant.detectionservice.statistics;

import com.elehnsherr.mutant.detectionservice.dnadetection.DNASequence;
import com.elehnsherr.mutant.detectionservice.dnadetection.DetectionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsServiceImplTest {

    @Mock
    private DetectionRepository detectionRepository;

    @InjectMocks
    private StatisticsServiceImpl statisticsService;


    @Before
    public void initialize() {
        statisticsService = new StatisticsServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyDNADetectionStatisticWhenOnlyMutant(){

        // Arrange
        DNASequence dnaSequenceMutant = new DNASequence();
        dnaSequenceMutant.setMutant(true);
        List<DNASequence> sequences = new ArrayList<DNASequence>();
        sequences.add(dnaSequenceMutant);
        when(detectionRepository.findAll()).thenReturn(sequences);

        // Act
        DNADetectionStatistic statistics = statisticsService.getDNADetectionStatistic();

        // Assert
        assertTrue(statistics.getCountMutantDna()==1L);
        assertTrue(statistics.getCountHumanDna()== 0);
    }

    @Test
    public void verifyDNADetectionStatistic(){

        // Arrange
        DNASequence dnaSequenceMutant = new DNASequence();
        dnaSequenceMutant.setMutant(true);
        List<DNASequence> sequences = new ArrayList<DNASequence>();
        sequences.add(dnaSequenceMutant);

        DNASequence dnaSequenceHuman = new DNASequence();
        dnaSequenceHuman.setMutant(false);
        sequences.add(dnaSequenceHuman);

        when(detectionRepository.findAll()).thenReturn(sequences);

        // Act
        DNADetectionStatistic statistics = statisticsService.getDNADetectionStatistic();

        // Assert
        assertTrue(statistics.getCountMutantDna()==1L);
        assertTrue(statistics.getCountHumanDna()== 1L);
        assertTrue(statistics.getRatio()== 1L);
    }
}
