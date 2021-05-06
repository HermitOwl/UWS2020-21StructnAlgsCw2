package com.coursework2.dynamicdatatypes;


/**
 * This class serves as a carrier class for Comparable implemented objects, in use with Dynamic Data Structures.
 * The Comparable object (payload) is wrapped to protect from unintended alteration.
 * @author James Agbotta
 *
 */
public class Node {
	// TODO: Complete all comments

	private Comparable payload;

	/**
	 * 
	 * Node class constructor, sets the payload to null by default.
	 * 
	 */
	public Node() {
		payload = null;
	}

	/**
	 * @param Comparable payload
	 * 
	 * Node class constructor, sets the payload to a recieved parameter
	 * 
	 */
	public Node(Comparable payload) {
		this.payload = payload;

	}

	/**
	 * 
	 * Method that returns the Comparable object stored in the Node object.
	 * 
	 * @return payload
	 */
	public Comparable getPayload() {
		return payload;
	}

	/**
	 * Modifies the payload with another Comparable object; 
	 * @param payload
	 */
	public void setPayload(Comparable payload) {
		this.payload = payload;
	}

	/**public boolean isEmpty()
	 * 
	 * 
	 * @return payload == null
	 */
	public boolean isEmpty() {
		return payload == null;
	}

	/**
	 * @param otherNode
	 * @return this.payload.compareTo(otherNode.getPayload()) == 0
	 * 
	 */
	public boolean equals(Node otherNode) {
		return this.payload.compareTo(otherNode.getPayload()) == 0;
	}

	/**
	 * 
	 * 
	 * @param otherNode
	 * @return return this.payload.compareTo(otherNode.getPayload()) > 0
	 */
	public boolean greaterThan(Node otherNode) {
		return this.payload.compareTo(otherNode.getPayload()) > 0;
	}

	/**
	 * @param otherNode
	 * 
	 *  @return this.payload.compareTo(otherNode.getPayload()) < 0;
	 */
	public boolean lessThan(Node otherNode) {
		return this.payload.compareTo(otherNode.getPayload()) < 0;
	}

	/**public String toString()
	 * Overriding the Object.toString() method to  return the result of the toString() method of the payload.
	 */
	@Override
	public String toString() {
		if (payload != null)
			return payload.toString();
		else
			return "null";
	}

}
