package com.coursework2.dynamicdatatypes;


public class ListNode extends Node{
	
	private ListNode nextNode;
	
	public ListNode() 
	{
		super();
		nextNode = new ListNode();
	}
	
	public ListNode(Comparable payload) 
	{
		super(payload);
		nextNode = new ListNode();
	}
	
	public ListNode getNextNode() {
		return nextNode;
	}
	
	
	public void setNextNode(ListNode nextNode) {
		this.nextNode = nextNode;
	}
	

	public void clearNextNode(ListNode nextNode) {
		nextNode = new ListNode();
	}

}
