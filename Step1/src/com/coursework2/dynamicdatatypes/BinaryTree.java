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
	
	public static int checkQuantity(Node n) //simple method for finding the  size of a tree from a node 
	{//TODO: Complete this
		int quantity =0;
		/**
		 * What needs doing 
		 * 1 count the root
		 * 2 if !null count the left
		 * 3 if !null count the right
		 * 
		 * 2 Count the left (assume the left is root)
		 * 2.1 if !null count the left
		 * 2.2 if !null count the right 
		 * 
		 * 3 Count the left (assume the left is root)
		 * 2.1 if !null count the left
		 * 2.2 if !null count the right 
		 */
		
		if(n != null) {
			quantity++;
			quantity+= checkQuantity(n.getBranchA());
			quantity+= checkQuantity(n.getBranchB());
		}
		return quantity;
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
	
	public void sortedInsertNode(Node x) 
	{
		//TODO Complete This
		this.rootNode.insert(x);
		
		
	}
	
	
	public void sortTree()
	{
		//TODo Complete this
	}
	
	public void RemoveNode() 
	{
		//TODO Complete this!
	}
	
	
	
}
