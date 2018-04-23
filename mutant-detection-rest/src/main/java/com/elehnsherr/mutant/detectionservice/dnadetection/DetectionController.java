package com.elehnsherr.mutant.detectionservice.dnadetection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetectionController {

    @Autowired
    private DetectionService detectionService;

    @PostMapping(path = "/mutant")
    public DNA verifyMutantDNASequence(@RequestBody final DNA dna) {
        return detectionService.verifyDNASequence(dna);
    }
}
