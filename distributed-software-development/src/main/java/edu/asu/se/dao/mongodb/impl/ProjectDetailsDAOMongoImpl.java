package edu.asu.se.dao.mongodb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import edu.asu.se.dao.ProjectDetailsDAO;
import edu.asu.se.dao.UserDAO;
import edu.asu.se.model.GitProjectDetails;
import edu.asu.se.model.User;

@Repository
public class ProjectDetailsDAOMongoImpl implements ProjectDetailsDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	UserDAO userDAO;

	private static final String USER_COLLECTION = "users";

	private static final String PROJECTDETAILS_COLLECTION = "projectDetails";

	@Override
	public List<GitProjectDetails> getProjectDetails(String userName) {
		User user = userDAO.findUserByName(userName);
		Query query = new Query(Criteria.where("_id").in(user.getProjects()));
		return mongoTemplate.find(query, GitProjectDetails.class, "projectDetails");
	}

	@Override
	public void insertProjectDetails(String userName, GitProjectDetails gitProjectDetails) {
		User user = userDAO.findUserByName(userName);
		Query query = new Query(
				Criteria.where("_id").in(user.getProjects()).and("projectUrl").is(gitProjectDetails.getProjectUrl()));
		GitProjectDetails availableProject = mongoTemplate.findOne(query, GitProjectDetails.class, "projectDetails");
		if (availableProject == null) {
			mongoTemplate.insert(gitProjectDetails, PROJECTDETAILS_COLLECTION);
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

	@Override
	public GitProjectDetails getBranchDetails(GitProjectDetails details) {
		BasicDBObject idCriteria = new BasicDBObject();
		idCriteria.put("_id", details.getId());
		BasicDBObject branchNameCriteria = new BasicDBObject();
		branchNameCriteria.put("branchName", details.getBranchDetails().get(0).getBranchName());
		BasicDBObject eleMatch = new BasicDBObject();
		eleMatch.put("$elemMatch", branchNameCriteria);
		idCriteria.append("branchDetails", eleMatch);

		BasicDBObject query = new BasicDBObject();
		query.put("branchDetails.branchName", details.getBranchDetails().get(0).getBranchName());

		DBObject result = mongoTemplate.getCollection(PROJECTDETAILS_COLLECTION).findOne(query, idCriteria);
		return mongoTemplate.getConverter().read(GitProjectDetails.class, result);

	}
}
