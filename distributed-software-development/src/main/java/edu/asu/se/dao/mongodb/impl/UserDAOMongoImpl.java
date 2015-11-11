package edu.asu.se.dao.mongodb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import edu.asu.se.dao.UserDAO;
import edu.asu.se.model.BranchDetails;
import edu.asu.se.model.CodeStatistics;
import edu.asu.se.model.FileActivityDetails;
import edu.asu.se.model.GitProjectDetails;
import edu.asu.se.model.User;
import edu.asu.se.model.UserActivityDetails;

@Repository
public class UserDAOMongoImpl implements UserDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String USER_COLLECTION = "users";

	@Override
	public boolean insertUserRegisterationDetails(User user) {
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		User availableUser = findUserByName(user.getUsername());
		if (availableUser != null) {
			return false;
		}
		mongoTemplate.insert(user, USER_COLLECTION);
		return true;
	}

	@Override
	public User findUserByName(String userName) {
		Query query = new Query(Criteria.where("username").is(userName));
		return mongoTemplate.findOne(query, User.class, USER_COLLECTION);
	}

	@Override
	public List<GitProjectDetails> getProjectDetails(String userName) {
		User user = findUserByName(userName);
		Query query = new Query(Criteria.where("_id").in(user.getProjects()));
		return mongoTemplate.find(query, GitProjectDetails.class, "projectDetails");
	}

	@Override
	public void insertProjectDetails(String userName, GitProjectDetails gitProjectDetails) {
		User user = findUserByName(userName);
		Query query = new Query(
				Criteria.where("_id").in(user.getProjects()).and("projectUrl").is(gitProjectDetails.getProjectUrl()));
		GitProjectDetails availableProject = mongoTemplate.findOne(query, GitProjectDetails.class, "projectDetails");
		if (availableProject == null) {
			mongoTemplate.insert(gitProjectDetails, "projectDetails");
		} else {
			availableProject.getBranchDetails().add(gitProjectDetails.getBranchDetails().get(0));
			mongoTemplate.save(availableProject, "projectDetails");
		}
		query = new Query(Criteria.where("projectUrl").is(gitProjectDetails.getProjectUrl()));
		availableProject = mongoTemplate.findOne(query, GitProjectDetails.class, "projectDetails");
		if (user.getProjects().contains(availableProject.getId())) {
			user.getProjects().add(availableProject.getId());
			mongoTemplate.save(user, USER_COLLECTION);
		}
	}

	private GitProjectDetails getBranchDetails(GitProjectDetails details) {
		BasicDBObject idCriteria = new BasicDBObject();
		idCriteria.put("_id", details.getId());
		BasicDBObject branchNameCriteria = new BasicDBObject();
		branchNameCriteria.put("branchName", details.getBranchDetails().get(0).getBranchName());
		BasicDBObject eleMatch = new BasicDBObject();
		eleMatch.put("$elemMatch", branchNameCriteria);
		idCriteria.append("branchDetails", eleMatch);

		BasicDBObject query = new BasicDBObject();
		query.put("branchDetails.branchName", details.getBranchDetails().get(0).getBranchName());

		DBObject result = mongoTemplate.getCollection("projectDetails").findOne(query, idCriteria);
		return mongoTemplate.getConverter().read(GitProjectDetails.class, result);

	}

	@Override
	public List<FileActivityDetails> getFileActivityDetails(GitProjectDetails details) {
		GitProjectDetails branchDetails = getBranchDetails(details);
		Query query = new Query(
				Criteria.where("_id").in(branchDetails.getBranchDetails().get(0).getFileActivityDetailsId()));
		return mongoTemplate.find(query, FileActivityDetails.class, "FileActivityDetails");
	}
	
	@Override
	public void insertFileActivityDetails(GitProjectDetails projDetails, FileActivityDetails fileDetail) {
		String fileId = "";
		Query query = new Query(
				Criteria.where("fileName").is(fileDetail.getFileName()).and("filePath").is(fileDetail.getFilePath()));
		FileActivityDetails availableFile = mongoTemplate.findOne(query, FileActivityDetails.class,
				"FileActivityDetails");
		if (availableFile != null) {
			fileDetail.setId(availableFile.getId());
		}

		mongoTemplate.save(fileDetail, "FileActivityDetails");

		fileId = fileDetail.getId();

		query = new Query(Criteria.where("projectName").is(projDetails.getProjectName()));
		String branchName = projDetails.getBranchDetails().get(0).getBranchName();
		projDetails = mongoTemplate.findOne(query, GitProjectDetails.class, "projectDetails");
		for (BranchDetails branchDetail : projDetails.getBranchDetails()) {
			if (branchDetail.getBranchName() == branchName) {
				if (branchDetail.getFileActivityDetailsId() == null) {
					List<String> fileIds = new ArrayList<String>();
					fileIds.add(fileId);
				} else if (!branchDetail.getFileActivityDetailsId().contains(fileId)) {
					branchDetail.getFileActivityDetailsId().add(fileId);
				}
			}
		}
		mongoTemplate.save(projDetails, "projectDetails");
	}

	@Override
	public List<UserActivityDetails> getUserActivityDetails(GitProjectDetails details) {
		GitProjectDetails branchDetails = getBranchDetails(details);
		Query query = new Query(
				Criteria.where("_id").in(branchDetails.getBranchDetails().get(0).getUserActivityDetailsId()));
		return mongoTemplate.find(query, UserActivityDetails.class, "UserActivityDetails");
	}

	public void insertUserActivityDetails(GitProjectDetails projDetails, UserActivityDetails userDetail) {
		mongoTemplate.insert(userDetail, "UserActivityDetails");
		projDetails = getBranchDetails(projDetails);
		projDetails.getBranchDetails().get(0).getFileActivityDetailsId().add(userDetail.getId());
		mongoTemplate.save(projDetails, "projectDetails");
	}

	@Override
	public List<CodeStatistics> getCodeStatistics(GitProjectDetails details) {
		GitProjectDetails branchDetails = getBranchDetails(details);
		Query query = new Query(
				Criteria.where("_id").in(branchDetails.getBranchDetails().get(0).getCodeStatisticsId()));
		return mongoTemplate.find(query, CodeStatistics.class, "CodeStatistics");
	}
}
