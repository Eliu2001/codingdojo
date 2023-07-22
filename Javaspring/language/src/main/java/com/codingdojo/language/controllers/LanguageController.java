package com.codingdojo.language.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.services.LanguageService;
import jakarta.validation.Valid;

@Controller
public class LanguageController {
	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/language")
	public String index(Model model) {
		List<Language> lang = languageService.allLanguage();
		model.addAttribute("languages", lang);
		return "/languages/index.jsp";
	}

	@PostMapping(value = "/add")
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/error";
		} else {
			languageService.create(lang);
			return "redirect:/language";
		}
	}

	@RequestMapping(value = "/language/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Language lang = languageService.findLanguage(id);
		if (lang == null) {
			return "redirect:/error";
		}
		model.addAttribute("language", lang);
		return "/languages/show.jsp";

	}

	@RequestMapping("/language/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
	    Language language = languageService.findLanguage(id);
	    if (language == null) {
	        return "redirect:/error";
	    }
	    model.addAttribute("language", language); //
	    return "/languages/edit.jsp";
	}

	@PutMapping("/language/{id}")
	public String update(@Valid Language lang, BindingResult result, @PathVariable("id") Long id) {
	    if (result.hasErrors()) {
	        return "edit.jsp";
	    } else {
	        languageService.update(id, lang);
	        return "redirect:/language";
	    }
	}

	@RequestMapping(value = "/language/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.delete(id);
        return "redirect:/language";
    }
}
