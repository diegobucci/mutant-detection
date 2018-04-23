package com.elehnsherr.mutant.detectionservice.dnadetection;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "dna")
public class DNASequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String[] dna;

    private boolean isMutant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getDna(){
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }
}
