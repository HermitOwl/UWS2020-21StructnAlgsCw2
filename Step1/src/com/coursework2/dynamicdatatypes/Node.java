package com.coursework2.dynamicdatatypes;

public class Node {
	private Object payload;
	private Node branchA;
	private Node branchB;

	
	
	public Node(Object payload)
	{
		this.payload = payload;
		branchA = null;
		branchB = null;
	}
	
	public Object getPayload() 
	{
		return payload;
	}
	
	public void setPayload(Object payload) 
	{
		this.payload = payload;
	}
	
	public void attachBranchA(Node branch) 
	{
		branchA = branch;
	}
	
	public void detachBranchA()
	{
		branchA = null;
	}
	
	public Node getBranchA() 
	{
		return branchA;
	}
	
	public void attachBranchB(Node branch) 
	{
		branchA = branch;
	}
	
	public void detachBranchB()
	{
		branchA = null;
	}
	
	public Node getBranchB()
	{
		return branchB;
	}
	
	@Override
	public String toString() 
	{
		return payload.toString();
	}
	
	

}
