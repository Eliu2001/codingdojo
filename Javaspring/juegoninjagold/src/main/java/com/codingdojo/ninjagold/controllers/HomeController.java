package com.codingdojo.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	private int gold = 0;
	private List<String> activities = new ArrayList<>();
	private final Random random = new Random();

	private int getRandomGold(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	@GetMapping("/gold")
    public String index(HttpSession session) {
        
        if (session.getAttribute("activities") == null) {
            session.setAttribute("activities", new ArrayList<String>());
        }
        session.setAttribute("gold", gold);
        session.setAttribute("activities", activities);

        return "index.jsp";
    }

	@PostMapping("/actividades")
	public String actividades(HttpSession session, @RequestParam String place) {
		int oroGanado=0;
		String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("LLLL d yyyy hh:mm a"));
		switch (place) {
		case "farm":
			oroGanado = getRandomGold(10, 20);
			activities.add("Has ganado " + oroGanado + " de oro desde la Granja con fecha " + formattedDate);
            break;
		case "cave":
			oroGanado = getRandomGold(5, 10);
			activities.add("Has ganado "+ oroGanado + " de oro desde la cueva con fecha "+ formattedDate);
			break;
		case "house":
			oroGanado = getRandomGold(2, 5);
			activities.add("Has Ganado "+ oroGanado + " de oro desde la casa con fecha "+ formattedDate);
			break;
		case "casino":
			oroGanado = getRandomGold(-50, 50);
			if(oroGanado >=0) {
			activities.add("has ganado " + oroGanado + " de oro desde el casino con fecha "+ formattedDate);
		}
			else {
				activities.add("¡oh noooo! has perdido  " + oroGanado + " de oro por apostar, con fecha "+ formattedDate);
			}
			break;
		default:
			break;
		}
		gold += oroGanado;
		session.setAttribute("gold", gold);
        session.setAttribute("activities", activities);
        return "redirect:/gold";
	}
}
