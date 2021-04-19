package com.coursework2.dynamicdatatypes;

public class BinaryTree {
	/**Things to remember 
	 *  1 Value versus reference
	 */
	private Node rootNode;
	private Node pointerNode; // Do you need this? probably for Searches.
	private int quantity; //temporary  measure?  I will need to count the quantity non-null elements.
	
	
	public BinaryTree() 
	{//In case I need it.
		this.rootNode = null ;
		pointerNode = null;
		quantity = 0; 
	}
	
	
	public BinaryTree(Node rootNode) 
	{
		this.rootNode = rootNode ;
		pointerNode = rootNode;
		quantity = 1; //one because it is initialised with a root node
	}
	
	
	
	public Node getRootNode() 
	{
		return rootNode;
	}
	
	public Node getPointerNode() 
	{
		return pointerNode;
	}
	
	public void setPointerNode(Node pointerNode)
	{
		
		this.pointerNode = pointerNode;
	}
	
	protected void checkQuantity() //I don't want this test getting out unless absolutely necessary for testing, 
	{//TODO: when possible (after testing) convert to  private
		//TODO: Complete this
		
	}
	
	public int getQuantity() 
	{
		return quantity; //TODO: Complete this
	}
	
	public Object[] traverseTreeInorder() 
	{
		/**
		 * 
		 */
		Object[] payloadList = new Object[quantity];
		//TODO complete this!!
		return payloadList;
	}
	public Object[] traverseTreePreOrder() 
	{
		/**
		 * 
		 */
		Object[] payloadList = new Object[quantity];
		//TODO complete this!!
		return payloadList;
	}
	public Object[] traverseTreePostOrder() 
	{
		/**
		 * 
		 */
		Object[] payloadList = new Object[quantity];
		//TODO complete this!!
		return payloadList;
	}
	public Object[] traverseTreeReverseOrder() 
	{
		/**
		 * 
		 */
		Object[] payloadList = new Object[quantity];
		//TODO complete this!!
		return payloadList;
	}
	
	public void insertNode(Node x) 
	{
		this.rootNode.insert(x);
		
		
	}
	
	public void RemoveNode() 
	{
		//TODO Complete this!
	}
	
	
	
}
