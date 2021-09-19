package com.springframework.spring5petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.springframework.spring5petclinic"})
public class Spring5PetclinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5PetclinicApplication.class, args);
	}

}
