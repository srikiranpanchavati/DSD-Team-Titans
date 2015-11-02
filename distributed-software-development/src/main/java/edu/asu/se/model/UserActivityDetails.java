package edu.asu.se.model;

import org.springframework.data.annotation.Id;

public class UserActivityDetails {

	@Id
	private String id;
	private int onlineTime;
	private String startDate;
	private int commitsMade;
	private int loc;
	private int buildbreaks;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(int onlineTime) {
		this.onlineTime = onlineTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getCommitsMade() {
		return commitsMade;
	}

	public void setCommitsMade(int commitsMade) {
		this.commitsMade = commitsMade;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public int getBuildbreaks() {
		return buildbreaks;
	}

	public void setBuildbreaks(int buildbreaks) {
		this.buildbreaks = buildbreaks;
	}

}