package com.elehnsherr.mutant.detectionservice.statistics;

import com.elehnsherr.mutant.detectionservice.dnadetection.DNASequence;
import com.elehnsherr.mutant.detectionservice.dnadetection.DetectionRepository;
import com.elehnsherr.mutant.detectionservice.dnadetection.exception.DNASequencesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    public static final String ONLY_MUTANTS_DETECTED_STATUS = "ONLY MUTANTS DETECTED";

    public static final String MUTANTS_DETECTED_STATUS = "MUTANTS / HUMANS DETECTED - STATISTICS";

    @Autowired
    private DetectionRepository detectionRepository;

    @Override
    public DNADetectionStatistic getDNADetectionStatistic() {
        List<DNASequence> dnaSequences = detectionRepository.findAll();
        if(null != dnaSequences && !dnaSequences.isEmpty()){
            Long countMutants = dnaSequences.stream().filter(x -> x.isMutant()).count();
            DNADetectionStatistic dnaDetectionStatistic = new DNADetectionStatistic();
            dnaDetectionStatistic.setCountMutantDna(countMutants);
            dnaDetectionStatistic.setCountHumanDna(dnaSequences.size() - countMutants);

            if(dnaDetectionStatistic.getCountHumanDna()>0){
                dnaDetectionStatistic.setRatio(dnaDetectionStatistic.getCountMutantDna().floatValue()/dnaDetectionStatistic.getCountHumanDna());
                dnaDetectionStatistic.setStatus(MUTANTS_DETECTED_STATUS);
            }
            else{
                dnaDetectionStatistic.setStatus(ONLY_MUTANTS_DETECTED_STATUS);
            }
            return dnaDetectionStatistic;
        } else {
            throw new DNASequencesNotFoundException("No DNA Sequences found");
        }
    }
}
