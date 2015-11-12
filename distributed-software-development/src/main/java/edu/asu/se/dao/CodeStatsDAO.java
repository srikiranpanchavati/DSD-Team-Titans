package edu.asu.se.dao;

import java.util.List;

import edu.asu.se.model.CodeStatistics;
import edu.asu.se.model.GitProjectDetails;

public interface CodeStatsDAO {
	
	public List<CodeStatistics> getCodeStatistics(GitProjectDetails details);

}
