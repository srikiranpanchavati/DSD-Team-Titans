package edu.asu.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.se.dao.UserDAO;
import edu.asu.se.model.CodeStatistics;
import edu.asu.se.model.FileActivityDetails;
import edu.asu.se.model.GitProjectDetails;
import edu.asu.se.model.UserActivityDetails;

@Controller
public class StatisticsController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/statistics**", method = RequestMethod.POST)
	public ModelAndView getStatistics(@ModelAttribute GitProjectDetails detail) {
		List<FileActivityDetails> fileDetails = userDAO.getFileActivityDetails(detail);
		List<UserActivityDetails> userDetails = userDAO.getUserActivityDetails(detail);
		List<CodeStatistics> codeStats = userDAO.getCodeStatistics(detail);
		ModelAndView model = new ModelAndView();
		model.addObject("userDetails", userDetails);
		model.addObject("fileDetails", fileDetails);
		model.addObject("codeStats", codeStats);
		model.setViewName("statistics");
		return model;
	}
}
