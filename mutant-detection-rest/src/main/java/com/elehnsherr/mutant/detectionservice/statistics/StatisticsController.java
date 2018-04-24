package com.elehnsherr.mutant.detectionservice.statistics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller that provides a service to get statistics based on stored DNA Sequences.
 */
@RestController
@RequestMapping("/")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping(method = RequestMethod.GET,path = "stats", produces = "application/json")
    public DNADetectionStatistic resumeDNADetectionStatistic() {
        return statisticsService.getDNADetectionStatistic();
    }
}
