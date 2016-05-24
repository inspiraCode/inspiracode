package com.inspiracode.generator.webapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StepOutput implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String document;
	private String status;
	private Set<String> canRead = new HashSet<String>();
	private Set<String> canUpdate = new HashSet<String>();
	private Set<String> canDelete = new HashSet<String>();
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StepOutput [document=" + document + ", status=" + status
				+ ", canRead=" + canRead + ", canUpdate=" + canUpdate
				+ ", canDelete=" + canDelete + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		StepOutput other = (StepOutput) obj;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
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
	 * @return the canRead
	 */
	public Set<String> getCanRead() {
		return canRead;
	}
	/**
	 * @param canRead the canRead to set
	 */
	public void setCanRead(Set<String> canRead) {
		this.canRead = canRead;
	}
	/**
	 * @return the canUpdate
	 */
	public Set<String> getCanUpdate() {
		return canUpdate;
	}
	/**
	 * @param canUpdate the canUpdate to set
	 */
	public void setCanUpdate(Set<String> canUpdate) {
		this.canUpdate = canUpdate;
	}
	/**
	 * @return the canDelete
	 */
	public Set<String> getCanDelete() {
		return canDelete;
	}
	/**
	 * @param canDelete the canDelete to set
	 */
	public void setCanDelete(Set<String> canDelete) {
		this.canDelete = canDelete;
	}
	
	
	
}
