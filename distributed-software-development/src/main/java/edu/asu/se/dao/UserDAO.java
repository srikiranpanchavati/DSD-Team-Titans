package edu.asu.se.dao;

import edu.asu.se.model.GitProjectDetails;
import edu.asu.se.model.User;

public interface UserDAO {

	public User findUserByName(String userName);
	public GitProjectDetails getProjectDetails(String userName);
}
