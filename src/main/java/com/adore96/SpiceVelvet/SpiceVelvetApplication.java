package com.adore96.SpiceVelvet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.adore96.SpiceVelvet.repository")
public class SpiceVelvetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiceVelvetApplication.class, args);
	}

}
