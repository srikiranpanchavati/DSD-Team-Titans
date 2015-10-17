package edu.asu.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.se.common.CommonInfo;
import edu.asu.se.dao.UserDAO;
import edu.asu.se.model.GitProjectDetails;

@Controller
public class ProfileController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/profile**", method = RequestMethod.GET)
	public ModelAndView profile(@ModelAttribute GitProjectDetails projectDetails) {

		ModelAndView model = new ModelAndView();
		projectDetails = userDAO.getProjectDetails(CommonInfo.getUserName());
		model.addObject("projectDetails", projectDetails);
		/*model.addObject("projectName", projectDetails.getProjectName());
		model.addObject("projectURL", projectDetails.getProjectURL());
		model.addObject("branch", projectDetails.getBranch());*/
		model.setViewName("profile");
		return model;
	}

}
