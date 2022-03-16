package de.bht.jwtserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
* Main Class to start the application "JwtServerApplication"
*
* Source 1: https://medium.com/javarevisited/lets-implement-jwt-based-authentication-in-spring-boot-7ea5e97fc1f2
* Source 2: https://www.youtube.com/watch?v=X80nJ5T7YpE&t=975s
* Code altered and extended for this project
*
* @author Fredi Benko
*/
@SpringBootApplication
public class JwtServerApplication {

	
	/**
	 * starting point for the application
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(JwtServerApplication.class, args);
	}

}
