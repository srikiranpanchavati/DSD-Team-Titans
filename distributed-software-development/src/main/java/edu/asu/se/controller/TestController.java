package edu.asu.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping(value="/statistics", method = RequestMethod.GET)
	public ModelAndView getDetails(){
		ModelAndView model = new ModelAndView();
		model.setViewName("statistics");
		return model;
	}
}
