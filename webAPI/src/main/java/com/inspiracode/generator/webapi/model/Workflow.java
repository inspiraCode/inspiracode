package com.inspiracode.generator.webapi.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Workflow implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String workflowName;
	private Set<Step> steps = new TreeSet<Step>();
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((workflowName == null) ? 0 : workflowName.hashCode());
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
		Workflow other = (Workflow) obj;
		if (workflowName == null) {
			if (other.workflowName != null)
				return false;
		} else if (!workflowName.equals(other.workflowName))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Workflow [workflowName=" + workflowName + ", steps=" + steps
				+ "]";
	}
	/**
	 * @return the workflowName
	 */
	public String getWorkflowName() {
		return workflowName;
	}
	/**
	 * @param workflowName the workflowName to set
	 */
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	/**
	 * @return the steps
	 */
	public Set<Step> getSteps() {
		return steps;
	}
	/**
	 * @param steps the steps to set
	 */
	public void setSteps(Set<Step> steps) {
		this.steps = steps;
	}
}
