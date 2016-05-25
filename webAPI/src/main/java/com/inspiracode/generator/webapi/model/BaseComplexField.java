package com.inspiracode.generator.webapi.model;

import java.io.Serializable;

/**
 * @author apacheco
 *
 */
public abstract class BaseComplexField implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private DataType type;
	private Boolean required;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldName == null) ? 0 : fieldName.hashCode());
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
		BaseComplexField other = (BaseComplexField) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		return true;
	}
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * @return the type
	 */
	public DataType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(DataType type) {
		this.type = type;
	}
	/**
	 * @return the required
	 */
	public Boolean getRequired() {
		return required;
	}
	/**
	 * @param required the required to set
	 */
	public void setRequired(Boolean required) {
		this.required = required;
	}
}
