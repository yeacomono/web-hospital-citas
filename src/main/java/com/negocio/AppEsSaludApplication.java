package com.negocio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.negocio"})
public class AppEsSaludApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEsSaludApplication.class, args);
	}

}
