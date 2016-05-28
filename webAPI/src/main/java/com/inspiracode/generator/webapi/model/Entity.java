package com.inspiracode.generator.webapi.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Map<String, DataType> requiredFields = new HashMap<String, DataType>();
	private Map<String, DataType> optionalFields = new HashMap<String, DataType>();
	private Set<BaseComplexField> complexFields;

	private EntityRelationship relationships = new EntityRelationship();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Entity other = (Entity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * @return the relationships
	 */
	public EntityRelationship getRelationships() {
		return relationships;
	}

	/**
	 * @param relationships
	 *            the relationships to set
	 */
	public void setRelationships(EntityRelationship relationships) {
		this.relationships = relationships;
	}

	/**
	 * @return the requiredFields
	 */
	public Map<String, DataType> getRequiredFields() {
		return requiredFields;
	}

	/**
	 * @param requiredFields
	 *            the requiredFields to set
	 */
	public void setRequiredFields(Map<String, DataType> requiredFields) {
		this.requiredFields = requiredFields;
	}

	/**
	 * @return the optionalFields
	 */
	public Map<String, DataType> getOptionalFields() {
		return optionalFields;
	}

	/**
	 * @param optionalFields
	 *            the optionalFields to set
	 */
	public void setOptionalFields(Map<String, DataType> optionalFields) {
		this.optionalFields = optionalFields;
	}

	/**
	 * @return the complexFields
	 */
	public Set<BaseComplexField> getComplexFields() {
		return complexFields;
	}

	/**
	 * @param complexFields
	 *            the complexFields to set
	 */
	public void setComplexFields(Set<BaseComplexField> complexFields) {
		this.complexFields = complexFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entity [name=" + name + ", requiredFields=" + requiredFields
				+ ", optionalFields=" + optionalFields + ", complexFields="
				+ complexFields + ", relationships=" + relationships + "]";
	}
}
