package com.elehnsherr.mutant.detectionservice.dnadetection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetectionServiceImpl implements DetectionService{

    @Autowired
    private DetectionRepository detectionRepository;

    @Override
    public DNA verifyDNASequence(DNA dnaSequence) {
        return null;
    }
}
