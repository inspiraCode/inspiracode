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
				+ description + ", roles=" + roles + ", deployments="
				+ deployments + "]";
	}

	private String projectName;
	private String description;
	private Set<String> roles = new HashSet<String>();
	private Set<Deployment> deployments = new HashSet<Deployment>();

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

	/**
	 * @return the deployments
	 */
	public Set<Deployment> getDeployments() {
		return deployments;
	}

	/**
	 * @param deployments the deployments to set
	 */
	public void setDeployments(Set<Deployment> deployments) {
		this.deployments = deployments;
	}
}