package edu.asu.se.model;

public class CodeStatistics {
	private String buildName;
	private String buildDate;
	private String triggeredBy;
	private int locChanged;
	private int compilationErrors;
	private int buildErrors;
	private int complexity;

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	public String getTriggeredBy() {
		return triggeredBy;
	}

	public void setTriggeredBy(String triggeredBy) {
		this.triggeredBy = triggeredBy;
	}

	public int getLocChanged() {
		return locChanged;
	}

	public void setLocChanged(int locChanged) {
		this.locChanged = locChanged;
	}

	public int getCompilationErrors() {
		return compilationErrors;
	}

	public void setCompilationErrors(int compilationErrors) {
		this.compilationErrors = compilationErrors;
	}

	public int getBuildErrors() {
		return buildErrors;
	}

	public void setBuildErrors(int buildErrors) {
		this.buildErrors = buildErrors;
	}

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}	
}
