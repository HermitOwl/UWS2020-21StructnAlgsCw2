package com.coursework2.dynamicdatatypes;

public class BinaryTree {
	/**Things to remember 
	 *  1 Value versus reference
	 */
	private Node rootNode;
	private BinaryTree low;
	private BinaryTree high;
	private int quantity;
	
	
	public BinaryTree() {
		rootNode=  new Node();
		low = null;
		high = null;
		quantity = 0;
	}
	
	public BinaryTree(Node rootNode) {
		this.rootNode=  rootNode;
		low = null;
		high = null;
		quantity = 1;
	}
	
	//Getter Methods
	
	public Node getRoot() 
	{
		return rootNode;
	}
	
	public BinaryTree getLow() 
	{
		return low;
	}
	
	
	public Node getLowNode() 
	{
		return low.getRoot();
	}
	
	public BinaryTree getHigh() 
	{
		return high;
	}
	
	public Node getHighNode() 
	{
		return high.getRoot();
	}
	
	
	public int getQuantity() 
	{
		return checkQuantity(this);//inefficient ;
	}
	
	//Setter Methods
	/**
	public void setRoot(Node rootNode) 
	{
		this.rootNode = rootNode;
	}
	

	public void setLow(BinaryTree low) 
	{
		this.low = low;
	}
	
	public void setLowNode(Node lowNode) 
	{
		low.setRoot(lowNode);
	}
	
	public void setHigh(BinaryTree high) 
	{
		this.high = high;
	}
	
	public void setHighNode(Node highNode) 
	{
		high.setRoot(highNode);
	}
	*/
	
	public void detachLowBranch() 
	{
		low = new BinaryTree();
	}
	
	public void detachHighBranch() 
	{
		high = new BinaryTree();
	}
	
	
	public void add(Node e) 
	{
		if((rootNode.isEmpty()) || (rootNode ==  null))
		{
			rootNode = e;
		}
		else if(rootNode.greaterThan(e)) 
		{
			if(low == null)
				low = new BinaryTree();
			low.add(e);
		}
		else if(rootNode.lessThan(e)) 
		{
			if(high == null)
				high = new BinaryTree();
			high.add(e);
		}
		

		
	}
	
	
	
	
	public static int checkQuantity(BinaryTree t) 
	{
		int temp = 0;
		if((t != null) && !t.getRoot().isEmpty()) {//if the node is empty, assume the rest of the tree is empty
			temp++;
			temp+=checkQuantity(t.getLow());
			temp+=checkQuantity(t.getHigh());
		}
		return temp;
	}
	public boolean contains(Node e) 
	{
		/**
		 * boolean temp = false;
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
		 */
		boolean temp= false;
		if((e !=  null) && !e.isEmpty())//if it's empty or null it will trigger true incorrectly
		{
			if((rootNode != null) && !rootNode.isEmpty()) //if the root is null or empty, assume the tree is empty
			{
				if(rootNode.equals(e))
					temp = true;
				else if(rootNode.greaterThan(e))
					if(low != null)
					temp = low.contains(e);
				else 
					if(high != null)
					temp = high.contains(e);
			}
		}
		
		
		
		return temp;
	}
	
	public Comparable[] toArray()
	{
		//TODO: Complete to Array, use in order Traversal
		return null;
	}
	
	
	
	
}
