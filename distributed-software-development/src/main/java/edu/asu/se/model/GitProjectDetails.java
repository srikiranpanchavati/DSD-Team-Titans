package edu.asu.se.model;

import org.springframework.data.annotation.Id;

public class GitProjectDetails {

	@Id
	private String id;
<<<<<<< HEAD
	private String userName;
=======
	private String username;
>>>>>>> master
	private String projectName;
	private String projectURL;
	private String branch;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

<<<<<<< HEAD
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
=======
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
>>>>>>> master
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectURL() {
		return projectURL;
	}

	public void setProjectURL(String projectURL) {
		this.projectURL = projectURL;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
}
