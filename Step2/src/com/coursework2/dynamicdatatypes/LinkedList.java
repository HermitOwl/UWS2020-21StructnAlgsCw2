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
	
	
	
	
}
