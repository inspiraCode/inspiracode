package com.inspiracode.generator.webapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Djson implements Serializable {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Djson [projectName=" + projectName + ", description="
				+ description + ", roles=" + roles + "]";
	}

	private String projectName;
	private String description;
	private Set<String> roles = new HashSet<String>();

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the roles
	 */
	public Set<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}