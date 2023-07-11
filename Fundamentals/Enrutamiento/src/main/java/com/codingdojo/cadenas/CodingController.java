package com.codingdojo.cadenas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CodingController {
	@RequestMapping("coding")
	public String coding() {
		return "¡Hola Coding Dojo!";
	}
	@RequestMapping("coding/python")
	public String python() {
		return "Python/Django fue increible" ;
	}
	@RequestMapping("coding/java")
	public String java() {
		return "Java/Spring es mejor" ;
	}
}
