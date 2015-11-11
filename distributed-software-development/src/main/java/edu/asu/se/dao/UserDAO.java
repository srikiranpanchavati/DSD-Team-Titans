package edu.asu.se.dao;

import java.util.List;

import edu.asu.se.model.CodeStatistics;
import edu.asu.se.model.FileActivityDetails;
import edu.asu.se.model.GitProjectDetails;
import edu.asu.se.model.User;
import edu.asu.se.model.UserActivityDetails;

public interface UserDAO {
	
	public boolean insertUserRegisterationDetails(User user);

	public User findUserByName(String userName);

	public List<GitProjectDetails> getProjectDetails(String userName);

	public void insertProjectDetails(String userName, GitProjectDetails gitProjectDetails);
	
	public void insertFileActivityDetails(GitProjectDetails projDetails,  FileActivityDetails fileDetail);

	public List<FileActivityDetails> getFileActivityDetails(GitProjectDetails details);

	public List<UserActivityDetails> getUserActivityDetails(GitProjectDetails details);

	public List<CodeStatistics> getCodeStatistics(GitProjectDetails details);
}
