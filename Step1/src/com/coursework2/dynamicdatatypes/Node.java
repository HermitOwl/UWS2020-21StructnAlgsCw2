package com.coursework2.dynamicdatatypes;

public class Node {
	private Comparable payload;
	private Node branchA;
	private Node branchB;

	
	
	public Node(Comparable payload)
	{
		this.payload = payload;
		branchA = null;
		branchB = null;
	}
	
	public Comparable getPayload() 
	{
		return payload;
	}
	
	public void setPayload(Comparable payload) 
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
	
	public void insert(Node x) 
	{
		//TODO: Complete this!! 
		/**
		 * Implement this at node level
		 *  basic condition 
		 *   if (x.payload < this.payload)
		 *   	if (BranchA == null)
		 *   		BranchA = x;
		 *   	Else branchA.insert(x);
		 *   Else if (x.paylaod > this.payload)
		 *   	if(BranchB== null)
		 *   		BranchB = x;
		 *   Else branchB.insert(x);
		 */
	}
	
	@Override
	public String toString() 
	{
		return payload.toString();
	}
	
	

}
