package edu.asu.se.dao.mongodb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

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
		Query query = new Query(Criteria.where("username").is(userName));
		return mongoTemplate.find(query, GitProjectDetails.class, USER_COLLECTION);
	}

	@Override
	public void insertProjectDetails(GitProjectDetails gitProjectDetails) {
		mongoTemplate.insert(gitProjectDetails, USER_COLLECTION);
	}

}
