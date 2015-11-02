package edu.asu.se.controller;

import java.util.List;

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
	public ModelAndView profile() {
		return getProfileDetails(null);
	}

	@RequestMapping(value = "/profile**", method = RequestMethod.POST)
	public ModelAndView profileUpdate(@ModelAttribute GitProjectDetails projectDetails) {

		return getProfileDetails(projectDetails);

	}

	public ModelAndView getProfileDetails(GitProjectDetails projectDetails) {
		String userName = CommonInfo.getUserName();
		if (projectDetails != null) {
			userDAO.insertProjectDetails(userName, projectDetails);
			projectDetails = null;
		}
		ModelAndView model = new ModelAndView();
		List<GitProjectDetails> projectDetailsList = userDAO.getProjectDetails(CommonInfo.getUserName());
		model.addObject("projectDetails", projectDetailsList);
		model.setViewName("profile");
		return model;
	}

}
