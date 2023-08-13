package com.codingdojo.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Rating;
import com.codingdojo.mvc.models.Show;
import com.codingdojo.mvc.models.User;
import com.codingdojo.mvc.services.RatingService;
import com.codingdojo.mvc.services.ShowService;
import com.codingdojo.mvc.services.UserService;
import com.codingdojo.mvc.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userS;
	@Autowired
	private ShowService showS;
	@Autowired
	private UserValidator userV;
	@Autowired
	private RatingService ratS;

//GETMAPPINGS 
	@GetMapping("/") //este es el metodo para enviar la info correspondiente al index, es decir al login y register
	public String registerLogin(@ModelAttribute("user") User user, HttpSession session, Model model) {
		if (session.getAttribute("errorMessage") != null) {
			model.addAttribute("errorMessage", session.getAttribute("errorMessage"));
			return "index.jsp";
		} else
			return "index.jsp";
	}

	@GetMapping("/logout")//desloguearse
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/shows")//envia la informacion al la pagina de show, enviando las tablas.
	public String home(HttpSession session, Model model) {
		Long uID = (Long) session.getAttribute("userId");
		User user = userS.findUserById(uID);
		List<Show> showList = showS.getAll();
		List<Double> average = new ArrayList<>();
		for (Show show : showList) {
			List<Double> ratings = ratS.averageByRating(show.getId());
            if (!ratings.isEmpty()) {
                Double promedio = ratings.get(0);

                if (promedio != null) {
                    promedio = Math.floor(promedio * 10) / 10;
                    average.add(promedio);
                } else {
                    average.add(0.0);
                }
            } else {
                average.add(0.0);
            }
        }
		model.addAttribute("averages", average);
		model.addAttribute("showList", showList);
		model.addAttribute("user", user);
		return "showList.jsp";
	}

	@GetMapping("/shows/new")//metodo para llegar a la pagina para crear un show 
	public String createForm(Model model, @ModelAttribute("show") Show show, HttpSession session) {
		Long userID = (Long) session.getAttribute("userId");
		@SuppressWarnings("unused")
		User user = userS.findUserById(userID);
		return "addShow.jsp";

	}

	@GetMapping(value = "/shows/{id}")//metodo para ver el show y sus caracteristicas
	public String show(@PathVariable("id") Long id, Model model, HttpSession session,
			@ModelAttribute("rating") Rating rating) {
		Show show = showS.findShow(id);
		Long showId = show.getId();
		Long userId = (Long) session.getAttribute("userId");
		User user = userS.findUserById(userId);
		List<Object[]> ratings = ratS.getRatingByID(showId);
		
		model.addAttribute("user", user);
		model.addAttribute("show", show);
		model.addAttribute("ratings", ratings);
		return "showShows.jsp";
	}

	@GetMapping(value = "/shows/{id}/edit")//metodo para editar el programa 
	public String edit(@PathVariable("id") Long id, Model model) {
		Show show = showS.findShow(id);
		model.addAttribute("show", show);
		return "edit.jsp";
	}

	// POSTMAPPINGS
	@PostMapping("/registration")//envia la informacion del usuario nuevo al crear una cuenta, validando
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userV.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			User user2 = userS.registerUser(user);
			session.setAttribute("userId", user2.getId());
		}
		return "redirect:/";
	}

	@PostMapping("/login")//metodo para corroborar y validar y asi entrar a la session 
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean isAuntentico = userS.authenticateUser(email, password);
		if (isAuntentico) {
			User user2 = userS.findByEmail(email);
			session.setAttribute("userId", user2.getId());
			return "redirect:/shows";
		} else {
			session.setAttribute("error", "Clave o email invalida");
			return "redirect:/";
		}
	}

	@PostMapping("/shows/new") //el metodo para enviar la info del nuevo show
	public String create(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "addShow.jsp";
		}

		if (showS.showExists(show.getName())) {
			model.addAttribute("showExistsError", "Show already exist.");
			return "addShow.jsp";
		}

		Long userId = (Long) session.getAttribute("userId");
		@SuppressWarnings("unused")
		String userName = userS.findUserById(userId).getName();
		showS.createShow(show);
		return "redirect:/shows";
	}

	@PostMapping("/shows/{id}/edit")//envia la informacion del edit de la informacion
	public String update(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			Show show2 = showS.findShow(id);
			Long userId = (Long) session.getAttribute("userId");
			@SuppressWarnings("unused")
			String userName = userS.findUserById(userId).getName();
			show2.setName(show.getName());
			show2.setNetwork(show.getNetwork());
			showS.updateShow(show2);
			return "redirect:/shows/" + show2.getId();
		}
	}

	@PostMapping("/shows/{id}/rate")//Metodo para crear el rate
	public String rate(@Valid @PathVariable("id") Long showId, @RequestParam("rating") Double rating,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userS.findUserById(userId);
		Show show = showS.findShow(showId);
		Rating newRating = new Rating();
		newRating.setRating(rating);
		newRating.setShow(show);
		newRating.setUser(user);
		ratS.createRating(newRating);
		return "redirect:/shows/" + showId;
	}

	@PostMapping(value = "/shows/{id}/delete")//Eliminar un show
	public String delete(@PathVariable("id") Long id) {
		showS.deleteShow(id);
		return "redirect:/shows";
	}

}
