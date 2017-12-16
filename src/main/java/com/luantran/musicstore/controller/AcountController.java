package com.luantran.musicstore.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luantran.musicstore.model.Genre;
import com.luantran.musicstore.model.Role;
import com.luantran.musicstore.model.Users;
import com.luantran.musicstore.repository.GenreRepository;
import com.luantran.musicstore.repository.RoleRepository;
import com.luantran.musicstore.service.SecurityService;
import com.luantran.musicstore.service.UserService;
import com.luantran.musicstore.validator.UserValidator;

@Controller
public class AcountController {
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	@Autowired
	private RoleRepository roleRepository;


	@GetMapping("/login")
	public String getLogin(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your password and email is invalid.");
		System.out.println("login");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		List<Genre> genres = genreRepository.findAll();
		model.addAttribute("genres", genres);
		return "login";
	}
	
	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/registration")
	public String registration(Model model,HttpServletRequest request) {
		model.addAttribute("userForm", new Users());
		System.out.println("userForm");
		List<Genre> genres = genreRepository.findAll();
		model.addAttribute("genres", genres);
		if(request.getUserPrincipal()!=null) {
			return "redirect:/";

		}
		return "registration";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") Users userForm, BindingResult bindingResult, Model model) {
		System.out.println("registrationa");
		List<Genre> genres = genreRepository.findAll();
		model.addAttribute("genres", genres);
		userValidator.validate(userForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			System.out.println("hasError");
			return "registration";
		}
		 HashSet<Role> roles = new HashSet<>();
         roles.add(roleRepository.findByName("ROLE_MEMBER"));
		
		userForm.setRoles(roles);
		userService.save(userForm);	
		securityService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());
		return "redirect:/";

	}

}
