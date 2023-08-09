package com.codingdojo.listaestudiantes.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Contact;
import com.codingdojo.mvc.models.Student;
import com.codingdojo.mvc.services.ContactService;
import com.codingdojo.mvc.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	private final ContactService contactService;
	private final StudentService studentService;

	public HomeController(ContactService contactService, StudentService studentService) {
		this.contactService = contactService;
		this.studentService = studentService;
	}

	@RequestMapping("/student/new")
	public String newStudent(@Valid @ModelAttribute("student") Student persona) {
		return "/shows/index.jsp";
	}

	@RequestMapping("/contact/new")
	public String newContact(Model model, @Valid @ModelAttribute("contact") Contact contact) {
		List<Student> students = studentService.obtenerStudentSinContact();
		model.addAttribute("students", students);
		return "/shows/new.jsp";
	}

	@RequestMapping(value = "/student/new", method = RequestMethod.POST)
	public String createpersons(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "/shows/index.jsp";
		} else {
			studentService.createStuden(student);
			return "redirect:/student/new";
		}
	}

	@RequestMapping(value = "/contact/new", method = RequestMethod.POST)
	public String createContacts(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
		if (result.hasErrors()) {
			return "/shows/new.jsp";
		} else {
	        contactService.createContact(contact);
	        return "redirect:/contact/new";
		}
	}
	@RequestMapping("/students")
	public String show(Model model) {
		List<Contact> contacts = contactService.allContact();
		model.addAttribute("contacts", contacts);
		return "/shows/show.jsp";
	}

}