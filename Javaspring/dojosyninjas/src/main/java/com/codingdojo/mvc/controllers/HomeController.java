package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.services.DojoService;
import com.codingdojo.mvc.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public HomeController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	@RequestMapping("/")
	public String index(Model model) {
		List<Dojo> dojo = dojoService.allDojo();
		model.addAttribute("dojos", dojo);
		return "/views/index.jsp";
	}
	@RequestMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo d) {
		return "/views/newDojo.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja n, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newNinja.jsp";
		}
		ninjaService.create(n);
		return "redirect:/ninjas/new";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newDojo.jsp";
		}
		dojoService.create(dojo);
		return "redirect:/dojos/new";
	}
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model, @Valid @ModelAttribute("ninja") Ninja n){
		List<Dojo> dojo = dojoService.allDojo();
		model.addAttribute("dojos", dojo);
		return "/views/newNinja.jsp";
	}
	@RequestMapping(value = "/dojos/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		if (dojo == null) {
			return "redirect:/error";
		}
		model.addAttribute("dojos", dojo);
		return "/views/show.jsp";

	}
}	