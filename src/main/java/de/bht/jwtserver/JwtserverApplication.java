package de.bht.jwtserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* Main Class to start the application
*
* Source https://medium.com/javarevisited/lets-implement-jwt-based-authentication-in-spring-boot-7ea5e97fc1f2
* Main Author: https://javabrains.io
* Code an die Projektarbeit angepasst
*/
@SpringBootApplication
public class JwtserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtserverApplication.class, args);
	}

}
