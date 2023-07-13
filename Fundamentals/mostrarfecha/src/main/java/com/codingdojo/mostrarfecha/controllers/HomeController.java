package com.codingdojo.mostrarfecha.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
    	Date fecha = new Date();
    	SimpleDateFormat formato = new SimpleDateFormat("EEEE, d 'de' MMMM, YYYY");
    	String nuevoform = formato.format(fecha);
    	model.addAttribute("nuevoform", nuevoform);
    	return "date.jsp";
    }
    @RequestMapping("/time")
    public String time (Model model) {
    	Date tiempo = new Date();
    	SimpleDateFormat hora = new SimpleDateFormat("hh:mm a");
    	String horafinal = hora.format(tiempo);
    	model.addAttribute("horafinal", horafinal);
    	return "time.jsp";
    }
}
