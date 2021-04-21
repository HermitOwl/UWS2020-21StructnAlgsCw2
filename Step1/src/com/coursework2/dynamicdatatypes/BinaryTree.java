package com.coursework2.dynamicdatatypes;

public class BinaryTree {
	/**Things to remember 
	 *  1 Value versus reference
	 */
	private Node rootNode;
	private Node pointerNode; // Do you need this? probably for Searches.
	private int quantity; 
	
	
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
	
	public static int checkQuantity(Node n) 
	{//TODO: Is this complete?
		int quantity =0;
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
	/**
	 // probably won't need them
	public Object[] traverseTreePreOrder() 
	{
		
		Object[] payloadList = new Object[quantity];
		//TODO complete this!!
		return payloadList;
	}
	public Object[] traverseTreePostOrder() 
	{
		
		Object[] payloadList = new Object[quantity];
		//TODO complete this!!
		return payloadList;
	}
	public Object[] traverseTreeReverseOrder() 
	{
		
		Object[] payloadList = new Object[quantity];
		//TODO complete this!!
		return payloadList;
	}
	*/

	public void insertNode(Node x) 
	{
		this.rootNode.insert(x);
		quantity = checkQuantity(rootNode);
		
		
	}
	
	
	
	public boolean contains(Node x) 
	{
		return rootNode.contains(x);
	}
	
	public void RemoveNode() 
	{
		//TODO Complete this!
	}
	
	
	
}
