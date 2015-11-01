package edu.asu.se.model;

import java.util.List;

public class BranchDetails {
	private String id;
	private String branchName;
	private String createdDate;
	private List<FileActivityDetails> fileActivityDetails;
	private List<CodeStatistics> codeStatistics;

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

	public List<FileActivityDetails> getFileActivityDetails() {
		return fileActivityDetails;
	}

	public void setFileActivityDetails(List<FileActivityDetails> fileActivityDetails) {
		this.fileActivityDetails = fileActivityDetails;
	}

	public List<CodeStatistics> getCodeStatistics() {
		return codeStatistics;
	}

	public void setCodeStatistics(List<CodeStatistics> codeStatistics) {
		this.codeStatistics = codeStatistics;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
