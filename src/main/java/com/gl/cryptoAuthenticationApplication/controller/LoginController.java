package com.gl.cryptoAuthenticationApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.cryptoAuthenticationApplication.bean.Cryptouser;
import com.gl.cryptoAuthenticationApplication.service.CryptouserService;

@RestController
public class LoginController {
	@Autowired
	private CryptouserService service;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@GetMapping(value="/index")
	public ModelAndView showIndexPage(){
		ModelAndView mv=new ModelAndView("index");
		return mv;	
	}
	@GetMapping(value="/register")
	public ModelAndView showUserRegistry(Model model) {
	     Cryptouser users=new Cryptouser();
	     ModelAndView mv=new  ModelAndView("registerUserPage");
	     mv.addObject("userRecord",users);
		return mv;
	}
	
	@PostMapping(value="/register")
	public ModelAndView saveUser(@ModelAttribute("userRecord")  Cryptouser users) {
		String encodedPassword = bCrypt.encode(users.getPassword()); // encryptes the password
		Cryptouser newUser=new Cryptouser();
        newUser.setUsername(users.getUsername());
        newUser.setPassword(encodedPassword);
         service.save(newUser);
		return new ModelAndView("index");
	}
	
	
	@GetMapping(value="/loginpage")
	 public ModelAndView showLoginPage() {
		 return new ModelAndView("loginPage");
	 }
	@GetMapping(value="/loginerror")
	 public ModelAndView showErrorPage() {
		 return new ModelAndView("loginErrorPage");
	 }
}