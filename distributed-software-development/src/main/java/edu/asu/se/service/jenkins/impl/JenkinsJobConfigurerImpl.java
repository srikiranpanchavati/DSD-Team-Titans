package edu.asu.se.service.jenkins.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.se.service.jenkins.GroovyScriptGenerator;
import edu.asu.se.service.jenkins.JenkinsJobConfigurer;

@Service
public class JenkinsJobConfigurerImpl implements JenkinsJobConfigurer {

	@Autowired
	GroovyScriptGenerator scriptGenerator;

	@Override
	public Boolean setupJob(String projectName, String rootPOMLoc) {
		// TODO replace booleans with user defined exceptions
		Boolean result = false;

		Boolean scriptCreation = scriptGenerator.generateScipt(projectName, rootPOMLoc);

		if (scriptCreation != Boolean.TRUE) {
			result = scriptCreation;
		} else {
			result = buildDSLJob();
		}

		return result;
	}

	private Boolean buildDSLJob() {
		// TODO HTTP GET MEthod to build jenkins job
		return true;
	}

}
