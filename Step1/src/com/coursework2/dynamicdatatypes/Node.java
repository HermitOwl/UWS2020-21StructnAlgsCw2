package com.coursework2.dynamicdatatypes;

public class Node {
	private Comparable payload;
	
	public Node()
	{
		payload = null;
	}
	
	
	public Node(Comparable payload)
	{
		this.payload = payload;
	
	}
	
	public Comparable getPayload() 
	{
		return payload;
	}
	
	public void setPayload(Comparable payload) 
	{
		this.payload = payload;
	}
	
	public boolean isEmpty() 
	{
		return payload == null;
	}
	public boolean equals(Node x) 
	{
		return this.payload.compareTo(x.getPayload()) == 0;
	}
	
	public boolean greaterThan(Node x) 
	{
		return this.payload.compareTo(x.getPayload()) > 0;
	}
	
	public boolean lessThan(Node x) 
	{
		return this.payload.compareTo(x.getPayload()) < 0;
	}
	
	
	@Override
	public String toString() 
	{
		if(payload !=null)
		return payload.toString();
		else return "null";
	}
	
	

}
