package com.elehnsherr.mutant.detectionservice.dnadetection;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "dna")
public class DNA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String sequence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
