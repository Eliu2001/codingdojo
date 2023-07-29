package com.codingdojo.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.services.ApiService;

@Controller
public class HomeController {

	private final ApiService ser;
	public HomeController(ApiService ser) {
		this.ser = ser;
	}
	@RequestMapping("/")
	public String index() {
		return "views/index.jsp";
	}
	@RequestMapping("/table1")
	public String coutriesSpeakSlovene(Model model) {
		List<Object[]> table = ser.countriesSlovene();
		model.addAttribute("table", table);
		return "/views/table1.jsp";
	}
	@RequestMapping("/table2")
	public String countryAndCities(Model model) {
		List<Object[]> table = ser.countryAndCities();
		model.addAttribute("table", table);
		return "/views/table2.jsp";
	}
	@RequestMapping("/table3")
	public String mexicoCitiesGreaterThan50000(Model model) {
		List<Object[]> table = ser.citiesInMexico();
		model.addAttribute("table", table);
		return "/views/table3.jsp";
	}
	@RequestMapping("/table4")
	public String table4(Model model) {
		List<Object[]> table = ser.findCountriesWithLanguagesPercentageGreaterThan89OrderByPercentageDesc();
		model.addAttribute("table", table);
		return "/views/table4.jsp";
	}
	@RequestMapping("/table5")
	public String table5(Model model) {
		List<Object[]> table = ser.findCountriesWithSurfaceAreaLessThan501AndPopulationGreaterThan100000();
		model.addAttribute("table", table);
		return "/views/table5.jsp";
	}
	@RequestMapping("/table6")
	public String table6(Model model) {
		List<Object[]> table = ser.findCountriesWithGovernmentFormAndCapitalAndLifeExpectancy();
		model.addAttribute("table", table);
		return "/views/table6.jsp";
	}
	@RequestMapping("/table7")
	public String table7(Model model) {
		List<Object[]> table = ser.findCitiesInBuenosAires();
		model.addAttribute("table", table);
		return "/views/table7.jsp";
	}
	@RequestMapping("/table8")
	public String table8(Model model) {
		List<Object[]> table = ser.countCountriesByRegion();
		model.addAttribute("table", table);
		return "/views/table8.jsp";
	}
}
