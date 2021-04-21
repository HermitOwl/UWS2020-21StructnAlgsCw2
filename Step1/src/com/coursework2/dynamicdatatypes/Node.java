package com.coursework2.dynamicdatatypes;

public class Node {
	private Comparable payload;
	//Why branchA and branchB?  because Left and right
	private Node branchA;
	private Node branchB;

	public Node()
	{
		payload =null;
		branchA = null;
		branchB = null;
	}
	
	
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
	public boolean equals(Node x) 
	{
		return this.payload.compareTo(x.payload) ==0;
	}
	
	public boolean greaterThan(Node x) 
	{
		return this.payload.compareTo(x.payload) > 0;
	}
	
	public boolean lessThan(Node x) 
	{
		return this.payload.compareTo(x.payload) < 0;
	}
	
	public void insert(Node x) 
	{
		if(this.greaterThan(x)) 
		{
			if(this.branchA == null)
			{
				branchA = x;
			}
			else
			{
				branchA.insert(x);
			}
		}
		else if (this.lessThan(x))
		{
			if(this.branchB == null)
			{
				branchB = x;
			}
			else
			{
				branchB.insert(x);
			}
		}
		
	}
	
	

	
	public boolean contains(Node x) 
	{//TODO Create Comparison methods for payloads;
		boolean temp = false;
		if(this.equals(x)) 
		{
			temp = true;
		}
		else
		{
			if ((branchA != null) && (this.greaterThan(x)))
			{
				temp = branchA.contains(x); 
			}
			else if ((branchB != null) && (this.lessThan(x)))
			{
				temp = branchB.contains(x); 
			}
		}
			
		

	return temp;
	}
	
	@Override
	public String toString() 
	{
		if(payload !=null)
		return payload.toString();
		else return "null";
	}
	
	

}
