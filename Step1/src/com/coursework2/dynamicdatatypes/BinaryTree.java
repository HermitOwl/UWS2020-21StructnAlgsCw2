package com.coursework2.dynamicdatatypes;

public class BinaryTree {
	/**Things to remember 
	 *  1 Value versus reference
	 */
	private Node rootNode;
	private Node pointerNode; // Do you need this? probably for Searahes.
	
	
	public BinaryTree(Node rootNode) 
	{
		this.rootNode = rootNode ;
		pointerNode = rootNode;
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
	
	
	/** Do you Really need this?
	public int compareNodes(Node a, Node b) 
	{
		//TODO: really complete this
		return 0;
	}
	*/
	
	public void traverseTree() 
	{
		//TODO complete this!!
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
