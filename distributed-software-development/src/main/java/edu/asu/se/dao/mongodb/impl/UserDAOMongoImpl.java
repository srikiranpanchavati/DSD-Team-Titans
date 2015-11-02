package edu.asu.se.dao.mongodb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;

import edu.asu.se.dao.UserDAO;
import edu.asu.se.model.GitProjectDetails;
import edu.asu.se.model.User;

@Repository
public class UserDAOMongoImpl implements UserDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String USER_COLLECTION = "users";

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
			query = new Query(Criteria.where("projectUrl").is(gitProjectDetails.getProjectUrl()));
			availableProject = mongoTemplate.findOne(query, GitProjectDetails.class, "projectDetails");
			user.getProjects().add(availableProject.getId());
			mongoTemplate.save(user, USER_COLLECTION);
		} else {
			availableProject.getBranchDetails().add(gitProjectDetails.getBranchDetails().get(0));
			mongoTemplate.save(availableProject, "projectDetails");

		}
	}

	@Override
	public GitProjectDetails getStats(GitProjectDetails details) {
		// Query query2 = new
		// Query(Criteria.where("branchDetails.branchName").is(details.getBranchDetails().get(0).getBranchName()));
		Query query = new Query(
				Criteria.where("branchDetails.branchName").is(details.getBranchDetails().get(0).getBranchName())).addCriteria(
				Criteria.where("_id").is(details.getId()).and("branchDetails").elemMatch(
								Criteria.where("branchName").is(details.getBranchDetails().get(0).getBranchName())));
		return mongoTemplate.findOne(query, GitProjectDetails.class, "projectDetails");
	}

}
