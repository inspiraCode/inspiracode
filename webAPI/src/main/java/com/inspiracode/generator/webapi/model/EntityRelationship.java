/**
 * 
 */
package com.inspiracode.generator.webapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alfredo
 *
 */
public class EntityRelationship implements Serializable {

	private static final long serialVersionUID = 1L;

	private Set<String> oneToOne = new HashSet<>();
	private Set<String> oneToMany = new HashSet<>();
	private Set<String> manyToMany = new HashSet<>();
	private Set<String> manyToOne = new HashSet<>();

	/**
	 * @return the oneToOne
	 */
	public Set<String> getOneToOne() {
		return oneToOne;
	}

	/**
	 * @param oneToOne
	 *            the oneToOne to set
	 */
	public void setOneToOne(Set<String> oneToOne) {
		this.oneToOne = oneToOne;
	}

	/**
	 * @return the oneToMany
	 */
	public Set<String> getOneToMany() {
		return oneToMany;
	}

	/**
	 * @param oneToMany
	 *            the oneToMany to set
	 */
	public void setOneToMany(Set<String> oneToMany) {
		this.oneToMany = oneToMany;
	}

	/**
	 * @return the manyToMany
	 */
	public Set<String> getManyToMany() {
		return manyToMany;
	}

	/**
	 * @param manyToMany
	 *            the manyToMany to set
	 */
	public void setManyToMany(Set<String> manyToMany) {
		this.manyToMany = manyToMany;
	}

	/**
	 * @return the manyToOne
	 */
	public Set<String> getManyToOne() {
		return manyToOne;
	}

	/**
	 * @param manyToOne
	 *            the manyToOne to set
	 */
	public void setManyToOne(Set<String> manyToOne) {
		this.manyToOne = manyToOne;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EntityRelationship [oneToOne=" + oneToOne + ", oneToMany="
				+ oneToMany + ", manyToMany=" + manyToMany + ", manyToOne="
				+ manyToOne + "]";
	}
	
	
	
}
