package edu.asu.se.model;

import java.util.ArrayList;
import java.util.Date;

public class FileActivityDetails {
	private String fileName;
	private String filePath;
	private Date createdDate;
	private String lastCommittedBy;
	private int commits;
	private int locSinceLastCommit;
	private ArrayList<UserActivityDetails> usersActivity;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getLocSinceLastCommit() {
		return locSinceLastCommit;
	}

	public void setLocSinceLastCommit(int locSinceLastCommit) {
		this.locSinceLastCommit = locSinceLastCommit;
	}

	public String getLastCommittedBy() {
		return lastCommittedBy;
	}

	public void setLastCommittedBy(String lastCommittedBy) {
		this.lastCommittedBy = lastCommittedBy;
	}

	public int getCommits() {
		return commits;
	}

	public void setCommits(int commits) {
		this.commits = commits;
	}

	public ArrayList<UserActivityDetails> getUsersActivity() {
		return usersActivity;
	}

	public void setUsersActivity(ArrayList<UserActivityDetails> usersActivity) {
		this.usersActivity = usersActivity;
	}
}
