package com.coursework2.dynamicdatatypes;

public class BinaryTree {
	//TODO:  Complete all comments 
	/**
	 *Binary Tree 
	 *
	 *@author James Agbotta
	 */
	private Node rootNode;
	private BinaryTree low;
	private BinaryTree high;
	private int quantity;

	/**
	 * BinaryTree()
	 * Constructor for the BinaryTree class
	 * 
	 * @param none
	 */
	public BinaryTree() {
		rootNode = new Node();
		low = null;
		high = null;
		quantity = 0;
	}
	
	/**
	 * BinaryTree(Node rootNode)
	 * Constructor for the BinaryTree class.
	 *  
	 * Sets the root node to  the incoming parameter 
	 * 
	 * @param Node rootNode
	 */
	public BinaryTree(Node rootNode) {
		this.rootNode = rootNode;
		low = new BinaryTree();
		high = new BinaryTree();
		quantity = 1;
	}

	// Getter Methods
	/**
	 * getRoot()
	 * 
	 * @return Node rootNode
	 */
	public Node getRoot() {
		return rootNode;
	}

	
	/**
	 * getLowNode()
	 * 
	 * @return low.getRoot() :  Returns the Branch (BinrayTree) with Nodes less than the root Node
	 *
	 */
	public BinaryTree getLow() {
		return low;
	}
	
	/**
	 * getLowNode()
	 * 
	 * @return low.getRoot() :  Returns the first Node less than the root Node
	 *
	 */
	
	public Node getLowNode() {
		return low.getRoot();
	}
	/**
	 * getHigh()
	 * 
	 * @return high :  Returns the Branch (BinrayTree) with Nodes greater than the root Node
	 *
	 */
	public BinaryTree getHigh() {
		return high;
	}
	/**
	 * getHighNode()
	 * 
	 * @return high.getRoot() :  Returns the first node greater than the root Node
	 *
	 */
	public Node getHighNode() {
		return high.getRoot();
	}

	public int getQuantity() {
		quantity = checkQuantity(this);
		return quantity;// inefficient ;
	}

	// Setter Methods These are blocked off due to lack of use
	/*
	 * public void setRoot(Node rootNode) { this.rootNode = rootNode; }
	 * 
	 * public void setLow(BinaryTree low) { this.low = low; }
	 * 
	 * public void setLowNode(Node lowNode) { low.setRoot(lowNode); }
	 * 
	 * public void setHigh(BinaryTree high) { this.high = high; }
	 * 
	 * public void setHighNode(Node highNode) { high.setRoot(highNode); }
	 */

	public void detachLowBranch() {
		low = new BinaryTree();
	}

	public void detachHighBranch() {
		high = new BinaryTree();
	}
	
	
	public void attachLowBranch(BinaryTree branch) 
	{
		//TODO: Complete This!
	} 
	
	public void attachHighBranch(BinaryTree branch) 
	{
		//TODO: Complete This!
	} 

	public void add(Node e) {
		// if the node is null then there's no point
		if ((e != null) && !e.isEmpty()) 
		{
			
			if ((rootNode != null) && !rootNode.isEmpty()) {
				if (rootNode.greaterThan(e)) {
					if (low != null) {
						if (low.getRoot().isEmpty())
							low = new BinaryTree(e);
						else
							low.add(e);
					} else {
						low = new BinaryTree(e);
					}
				} else if (rootNode.lessThan(e)) {
					if (high != null) {
						if (high.getRoot().isEmpty()) {
							high = new BinaryTree(e);
						} else
							high.add(e);
					} else {
						high = new BinaryTree(e);
					}

				}
			} else {

				rootNode = e;
			}

		}

	}

	public static int checkQuantity(BinaryTree t) {
		int temp = 0;
		if ((t != null) && !t.getRoot().isEmpty()) {// if the node is empty, assume the rest of the tree is empty
			temp++;
			temp += checkQuantity(t.getLow());
			temp += checkQuantity(t.getHigh());
		}
		return temp;
	}

	public boolean contains(Node e) {
		boolean temp = false;
		if ((e != null) && !e.isEmpty())// if it's empty or null it will trigger true incorrectly
		{
			if ((rootNode != null) && !rootNode.isEmpty()) // if the root is null or empty, assume the tree is empty
			{
				if (rootNode.equals(e))
					temp = true;
				else if (rootNode.greaterThan(e)) {
					if (low != null)
						temp = low.contains(e);
				} else if (rootNode.lessThan(e)) {
					if (high != null)
						temp = high.contains(e);
				}
			}
		}

		return temp;
	}

	public static String stringUp(BinaryTree t) {
		//TODO Decide whether this will be to string  or something else
		String temp = "";
		if ((t != null) && !t.getRoot().isEmpty()) {// if the node is empty, assume the rest of the tree is empty

			temp = temp + stringUp(t.getLow()) + "\n";
			temp = temp + t.getRoot().toString();
			temp = temp + stringUp(t.getHigh());
		}
		return temp;
	}
	
	
	public Node remove(Node e) 
	{
	//TODO Complete this!!!
		Node removed = new Node();
		return removed;
	}



}
