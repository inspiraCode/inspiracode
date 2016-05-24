package com.inspiracode.generator.webapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Step implements Serializable, Comparable<Step> {
	
	private static final long serialVersionUID = 1L;
	
	private StepInput input = new StepInput();
	private Processable process;
	private Set<StepOutput> outputs = new HashSet<StepOutput>();
	private String stepName;
	private int sequence;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((stepName == null) ? 0 : stepName.hashCode());
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
		Step other = (Step) obj;
		if (stepName == null) {
			if (other.stepName != null)
				return false;
		} else if (!stepName.equals(other.stepName))
			return false;
		return true;
	}
	/**
	 * @return the stepName
	 */
	public String getStepName() {
		return stepName;
	}
	/**
	 * @param stepName the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	/**
	 * @return the sequence
	 */
	public int getSequence() {
		return sequence;
	}
	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Step [input=" + input + ", process=" + process + ", outputs="
				+ outputs + ", stepName=" + stepName + ", sequence=" + sequence
				+ "]";
	}
	/**
	 * @return the input
	 */
	public StepInput getInput() {
		return input;
	}
	/**
	 * @param input the input to set
	 */
	public void setInput(StepInput input) {
		this.input = input;
	}
	/**
	 * @return the process
	 */
	public Processable getProcess() {
		return process;
	}
	/**
	 * @param process the process to set
	 */
	public void setProcess(Processable process) {
		this.process = process;
	}
	/**
	 * @return the outputs
	 */
	public Set<StepOutput> getOutputs() {
		return outputs;
	}
	/**
	 * @param outputs the outputs to set
	 */
	public void setOutputs(Set<StepOutput> outputs) {
		this.outputs = outputs;
	}
	@Override
	public int compareTo(Step o) {		
		return sequence - o.sequence;
	}
}
