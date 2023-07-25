package com.codingdojo.onetoone.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.onetoone.models.License;
import com.codingdojo.onetoone.models.Person;
import com.codingdojo.onetoone.services.LicenseService;
import com.codingdojo.onetoone.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public HomeController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	@RequestMapping("/")
	public String index(Model model) {
		List<Person> person = personService.allPerson();
		model.addAttribute("persons", person);
		return "/views/index.jsp";
	}
	@RequestMapping("/persons/new")
	public String newPerson(@Valid @ModelAttribute("person") Person person) {
		return "/views/newPerson.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newLicense.jsp";
		}
		licenseService.create(license);
		return "redirect:/licenses/new";
	}
	
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("user") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newPerson.jsp";
		}
		personService.create(person);
		return "redirect:/persons/new";
	}
	@RequestMapping("/licenses/new")
	public String newLicense(Model model, @Valid @ModelAttribute("license") License license){
		List<Person> persons = personService.personasSinLicencia();
		model.addAttribute("persons", persons);
		return "/views/newLicense.jsp";
	}
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Person per = personService.findPerson(id);
		if (per == null) {
			return "redirect:/error";
		}
		model.addAttribute("person", per);
		return "/views/show.jsp";

	}
}		
