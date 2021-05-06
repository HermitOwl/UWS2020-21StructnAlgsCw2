package com.coursework2.dynamicdatatypes;

public class LinkedList {

	private ListNode head;
	private ListNode current;
	private int length;
	
	public LinkedList() 
	{
		head = new ListNode();
		current = head;
		length =0;
	}
	
	public LinkedList(ListNode head) 
	{
		this.head = head;
		current = head;
		length =1;
	}
	
	public void add(Comparable payload) 
	{
		if(payload!=null) 
		{
			if(head != null || !head.isEmpty()) 
			{
				if(!head.getPayload().equals(payload)) {
					
				}
			}
		}
		
	}
	
	
	public Comparable getProduct(int index) 
	{
		return null;
	}
	
	public boolean contains (Comparable payload) 
	{
		return false;
	}
	
	
	public Comparable[] toArray() 
	{
		return null;
	}
	
	
	public Comparable remove(int index) {
		return null;
		
	}
	
	public boolean remove(Comparable payload) {
		return false;
		
	}
	
	
	
	
}
