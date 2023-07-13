package com.codingdojo.holahumano;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Humano {

	@GetMapping("/")
	public String holaHumano(@RequestParam(value = "name", defaultValue = "Humano") String nombre) {
		String mensaje = "Hello "+ nombre;
		return "<h1>"+mensaje+"</h1><br><p>Welcome to Springboot!</p>";
	}
}
