package com.jeremy.CoursJAVA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CoursJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursJavaApplication.class, args);
	}

}
