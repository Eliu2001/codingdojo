package com.codingdojo.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.User;
import com.codingdojo.mvc.services.UserService;
import com.codingdojo.mvc.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

// imports removidos para resumir.
@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    UserValidator userValidator;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationpage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginpage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "registrationpage.jsp";
    	}
    	else {
    		User u = userService.registerUser(user);
    		session.setAttribute("UserId", u.getId());
    		return "redirect:/home";
    		
    	}
    //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    //Si el usuario está autenticado, guarde su id de usuario en el objeto Session
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}
    	else {
    		model.addAttribute("Error, credencial invalidas, por favor intentelo nuevamente");
    		return "redirect:/login";
    	}
    //sino agregue un mensaje de error y retorne a la página de inicio de sesión.
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    	Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {
            // Obtener el usuario desde el UserService por su ID
            User user = userService.findUserById(userId);

            // Agregar el usuario al modelo
            model.addAttribute("user", user);

            // Retornar a la página principal
            return "homepage.jsp"; // Cambia "home" por el nombre de tu página principal
        } else {
            // Si no se encuentra el userId en la sesión, redirigir al inicio de sesión
            return "redirect:/login"; // Cambia "/login" por la ruta a tu página de inicio de sesión
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
        // redireccionar a la página de inicio de sesión.
    }
}