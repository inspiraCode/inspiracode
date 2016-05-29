package com.inspiracode.generator.webapi.restControllers;

import java.io.Serializable;

public class CommonJsonResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	public CommonJsonResponse() {
		this.error = false;
		this.responseDescription = "OK";
	}

	public CommonJsonResponse(String responseDescription) {
		this.responseDescription = responseDescription;
		this.error = true;
	}

	private Boolean error = false;
	private String responseDescription;

	/**
	 * @return the error
	 */
	public Boolean getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(Boolean error) {
		this.error = error;
	}

	/**
	 * @return the responseDescription
	 */
	public String getResponseDescription() {
		return responseDescription;
	}

	/**
	 * @param responseDescription
	 *            the responseDescription to set
	 */
	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
}
