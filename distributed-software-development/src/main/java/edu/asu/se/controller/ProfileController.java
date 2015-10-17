package edu.asu.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
	@RequestMapping(value = "/profile**", method = RequestMethod.GET)
	public ModelAndView profile() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Profile Page");
		model.addObject("message", "Welcome Home");
		model.setViewName("profile");

		return model;
	}
}
