package com.example.daoukiwoom_innovation_technical_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DaoukiwoomInnovationTechnicalTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaoukiwoomInnovationTechnicalTestApplication.class, args);
	}

}
