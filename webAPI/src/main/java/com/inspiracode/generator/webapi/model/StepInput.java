package com.inspiracode.generator.webapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StepInput implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String document;
	private String status;
	private Set<String> roles = new HashSet<String>();
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StepInput [document=" + document + ", status=" + status
				+ ", roles=" + roles + "]";
	}
	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the roles
	 */
	public Set<String> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
}
