package com.inspiracode.generator.webapi.model;

import java.io.Serializable;

public class Deployment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String appName;
	private String version;
	private String database;
	private String middleWareTechnology;
	private String frontEndTechnology;
	private String settingsFile;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Deployment [appName=" + appName + ", version=" + version
				+ ", database=" + database + ", middleWareTechnology="
				+ middleWareTechnology + ", frontEndTechnology="
				+ frontEndTechnology + ", settingsFile=" + settingsFile + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appName == null) ? 0 : appName.hashCode());
		result = prime * result
				+ ((database == null) ? 0 : database.hashCode());
		result = prime
				* result
				+ ((frontEndTechnology == null) ? 0 : frontEndTechnology
						.hashCode());
		result = prime
				* result
				+ ((middleWareTechnology == null) ? 0 : middleWareTechnology
						.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deployment other = (Deployment) obj;
		if (appName == null) {
			if (other.appName != null)
				return false;
		} else if (!appName.equals(other.appName))
			return false;
		if (database == null) {
			if (other.database != null)
				return false;
		} else if (!database.equals(other.database))
			return false;
		if (frontEndTechnology == null) {
			if (other.frontEndTechnology != null)
				return false;
		} else if (!frontEndTechnology.equals(other.frontEndTechnology))
			return false;
		if (middleWareTechnology == null) {
			if (other.middleWareTechnology != null)
				return false;
		} else if (!middleWareTechnology.equals(other.middleWareTechnology))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}
	/**
	 * @param database the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}
	/**
	 * @return the middleWareTechnology
	 */
	public String getMiddleWareTechnology() {
		return middleWareTechnology;
	}
	/**
	 * @param middleWareTechnology the middleWareTechnology to set
	 */
	public void setMiddleWareTechnology(String middleWareTechnology) {
		this.middleWareTechnology = middleWareTechnology;
	}
	/**
	 * @return the frontEndTechnology
	 */
	public String getFrontEndTechnology() {
		return frontEndTechnology;
	}
	/**
	 * @param frontEndTechnology the frontEndTechnology to set
	 */
	public void setFrontEndTechnology(String frontEndTechnology) {
		this.frontEndTechnology = frontEndTechnology;
	}
	/**
	 * @return the settingsFile
	 */
	public String getSettingsFile() {
		return settingsFile;
	}
	/**
	 * @param settingsFile the settingsFile to set
	 */
	public void setSettingsFile(String settingsFile) {
		this.settingsFile = settingsFile;
	}
	
}
