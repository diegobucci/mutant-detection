package com.elehnsherr.mutant.detectionservice.dnadetection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectionRepository extends JpaRepository<DNASequence, Long> {


}
