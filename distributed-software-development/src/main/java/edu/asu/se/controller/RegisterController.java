package edu.asu.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView getDetails(){
		ModelAndView model = new ModelAndView();
		model.setViewName("RegistrationPage");
		return model;
	}
}
