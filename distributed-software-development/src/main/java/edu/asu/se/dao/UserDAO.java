package edu.asu.se.dao;

import java.util.List;

import edu.asu.se.model.GitProjectDetails;
import edu.asu.se.model.User;

public interface UserDAO {

	public User findUserByName(String userName);

	public List<GitProjectDetails> getProjectDetails(String userName);

	public void insertProjectDetails(String userName, GitProjectDetails gitProjectDetails);
	
	public GitProjectDetails getStats(GitProjectDetails details);
}
