package com.elehnsherr.mutant.detectionservice.dnadetection;

import com.elehnsherr.api.detection.DNADetectionService;
import com.elehnsherr.api.exception.InvalidDNATableException;
import com.elehnsherr.api.exception.InvalidNitrogenBaseCharsSequenceException;
import com.elehnsherr.mutant.detectionservice.dnadetection.exception.DNASequencesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetectionServiceImpl implements DetectionService{

    @Autowired
    private DetectionRepository detectionRepository;

    @Autowired
    private DNADetectionService dnaDetectionService;

    @Override
    public DNASequence verifyDNASequence(DNASequence dnaSequence)
            throws InvalidNitrogenBaseCharsSequenceException, InvalidDNATableException {

        if(dnaDetectionService.isMutantDetected(dnaSequence.getDna())){
            dnaSequence.setMutant(true);
        }
        detectionRepository.save(dnaSequence);
        return dnaSequence;
    }
}
