package com.elehnsherr.mutant.detectionservice.dnadetection;


import com.elehnsherr.api.exception.InvalidDNATableException;
import com.elehnsherr.api.exception.InvalidNitrogenBaseCharsSequenceException;
import com.elehnsherr.mutant.detectionservice.dnadetection.exception.InvalidDNASequenceDetectedException;
import com.elehnsherr.mutant.detectionservice.dnadetection.exception.MutantNotDetectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DetectionController {

    @Autowired
    private DetectionService detectionService;

    @RequestMapping(method = RequestMethod.POST,path = "mutant",produces = "application/json", consumes = "application/json")
    public DNASequence verifyMutantDNASequence(@RequestBody final DNASequence dna) {
        try {
            DNASequence validatedSequence = detectionService.verifyDNASequence(dna);
            if(validatedSequence.isMutant())
                return dna;

            throw new MutantNotDetectedException();

        } catch (InvalidNitrogenBaseCharsSequenceException e) {
            throw new InvalidDNASequenceDetectedException();
        } catch (InvalidDNATableException e) {
            throw new InvalidDNASequenceDetectedException();
        }
    }
}
