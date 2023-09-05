package com.talentsprint.cycleshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CycleshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CycleshopApplication.class, args);
	}

}
