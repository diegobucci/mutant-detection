package com.elehnsherr.mutant.detectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.elehnsherr.api","com.elehnsherr.mutant"})
public class MutantDetectionRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantDetectionRestApplication.class, args);
	}
}
