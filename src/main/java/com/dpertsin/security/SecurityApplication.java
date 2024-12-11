package com.dpertsin.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the SecurityApplication.
 * This class is responsible for bootstrapping the Spring Boot application.
 */
@SpringBootApplication
public class SecurityApplication {

	/**
	 * Indicates whether the user is enabled or disabled.
	 *
	 * @return true if the user is enabled, false otherwise
	 */
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
