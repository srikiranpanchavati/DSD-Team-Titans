package edu.asu.se.model;

import java.util.ArrayList;

public class BranchDetails {
	private String branchName;
	private String createdDate;
	private ArrayList<FileActivityDetails> fileActivityDetails;
	private ArrayList<CodeStatistics> codeStatistics;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public ArrayList<FileActivityDetails> getFileActivityDetails() {
		return fileActivityDetails;
	}

	public void setFileActivityDetails(ArrayList<FileActivityDetails> fileActivityDetails) {
		this.fileActivityDetails = fileActivityDetails;
	}

	public ArrayList<CodeStatistics> getCodeStatistics() {
		return codeStatistics;
	}

	public void setCodeStatistics(ArrayList<CodeStatistics> codeStatistics) {
		this.codeStatistics = codeStatistics;
	}

}
