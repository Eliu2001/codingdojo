package com.codingdojo.contador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index1(HttpSession session) {
		if (session.getAttribute("count") == null)
		{
			session.setAttribute("count", 0);
		}
		Integer count = (Integer) session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		
		return "index.jsp";
	}
	@RequestMapping("/count")
	public String home() {
		return "contador.jsp";
	}
	@RequestMapping("/cerrarsesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "contador.jsp";
	}
}
