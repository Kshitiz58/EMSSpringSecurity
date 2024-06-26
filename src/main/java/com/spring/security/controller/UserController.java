package com.spring.security.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.security.model.MyUser;
import com.spring.security.model.Subscriber;
import com.spring.security.repository.CustomUserRepository;
import com.spring.security.service.SubscriberService;
import com.spring.security.utlis.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private SubscriberService subService;
	
	@Autowired 
	private CustomUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping({"/","/login"})
	public String getHomepage() {
		return "index";
	}
	@GetMapping("/admin/home")
	public String getAdminpage() {
		return "adminHome";
	}
	@GetMapping("/user/home")
	public String getUserpage() {
		return "userHome";
	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute MyUser user, HttpSession session, 
			@RequestParam("g-recaptcha-response") String recaptCode) throws IOException{
		if(VerifyRecaptcha.verify(recaptCode)) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepo.save(user);
		}
		return "redirect:/";
	}
	
	@PostMapping({"/","/login"})
		public String getSubsriber(@ModelAttribute Subscriber subsciber) {
			subService.SubscriberEmail(subsciber);
			return "redirect:/";
		}
	
}
