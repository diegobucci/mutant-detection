package com.elehnsherr.mutant;


import com.elehnsherr.mutant.detection.DNADetectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MutantDetectionApplication implements CommandLineRunner{

    @Autowired
    private DNADetectionServiceImpl dnaDetectionServiceImpl;

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MutantDetectionApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}

    @Override
    public void run(String... args) throws Exception{
	    if(args!=null && args.length>0) {
            System.out.println("Starting Mutant Detection API ......starting to process DNA");
            boolean isDetected = dnaDetectionServiceImpl.isMutantDetected(args);
            System.out.println("DNA Sequence provided result = " + (isDetected ? "IS MUTANT!!" : "NOT MUTANT"));
        }
    }
}
