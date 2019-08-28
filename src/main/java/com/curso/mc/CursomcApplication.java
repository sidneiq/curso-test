package com.curso.mc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	

	//https://github.com/acenelio/springboot2-ionic-backend
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	/**
	 * CommandLineRunner : executa uma ação na instanciação do projeto
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------------------------");
		System.out.println("CursomcApplication:run ...");
		
		
		
		
		System.out.println("---------------------------------");
	}

}
