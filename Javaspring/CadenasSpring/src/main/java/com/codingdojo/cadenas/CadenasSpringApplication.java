package com.codingdojo.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class CadenasSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasSpringApplication.class, args);
	}
	@RequestMapping("/")
	public String cliente() {
		return "Hola mi estimado, ¿Un cafesito?";
	}
	@RequestMapping("/random")
	public String spring() {
		return "Spring boot es lo que necesita si quiere programar de la mejor manera";
	}
}
