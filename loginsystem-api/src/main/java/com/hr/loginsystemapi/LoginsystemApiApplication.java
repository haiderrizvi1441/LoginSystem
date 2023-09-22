package com.hr.loginsystemapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LoginsystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginsystemApiApplication.class, args);
		System.out.println("L-O-G-I-N  S-Y-S-T-E-M  I-S  W-O-R-K-I-N-G");
	}

}
