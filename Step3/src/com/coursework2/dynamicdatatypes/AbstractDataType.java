package com.coursework2.dynamicdatatypes;

public abstract class AbstractDataType {

	private Node rootNode;
	private int quantity;
	
	public AbstractDataType() 
	{
		rootNode = new Node();
		quantity = 0;
	}
	
	public AbstractDataType(Node rootNode) 
	{
		this.rootNode =rootNode;
		quantity = 1;
	}
	
}
