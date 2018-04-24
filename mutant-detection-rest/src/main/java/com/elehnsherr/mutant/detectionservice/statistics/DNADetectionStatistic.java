package com.elehnsherr.mutant.detectionservice.statistics;

public class DNADetectionStatistic {

    private Long countMutantDna;

    private Long countHumanDna;

    private float ratio;

    private String status;


    public Long getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(Long countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public Long getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(Long countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
