package com.elehnsherr.mutant;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.Banner;

@SpringBootApplication
public class MutantDetectionApplication implements CommandLineRunner{

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MutantDetectionApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting Mutant Detection API ......starting to process DNA");
    }
}
