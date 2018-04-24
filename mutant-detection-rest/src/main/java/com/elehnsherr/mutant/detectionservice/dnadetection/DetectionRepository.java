package com.elehnsherr.mutant.detectionservice.dnadetection;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Base repository based on @{@link JpaRepository}
 */
public interface DetectionRepository extends JpaRepository<DNASequence, Long> {


}
