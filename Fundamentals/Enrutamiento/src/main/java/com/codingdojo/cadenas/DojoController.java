package com.codingdojo.cadenas;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DojoController {
	@RequestMapping("{dojo}")
	public String dojo(@PathVariable String dojo) {
		switch (dojo) {
		case "dojo":
			return  "¡El Dojo es increíble!";
		case "burbank-dojo":
			return "El Dojo Burbank está localizado al sur de California";
		case "san-jose":
			return "El Dojo SJ es el cuartel general";
		default: 
			return "La ruta no es válida";
		}
		
	}
		

}
