package com.coursework2.dynamicdatatypes;

public class BinaryTree {
	/**
	 * Things to remember:
	 *  1 Value versus reference
	 *  Recursion Recursion Recursion
	 */
	private Node rootNode;
	private BinaryTree low;
	private BinaryTree high;
	private int quantity;

	public BinaryTree() {
		rootNode = new Node();
		low = null;
		high = null;
		quantity = 0;
	}

	public BinaryTree(Node rootNode) {
		this.rootNode = rootNode;
		low = new BinaryTree();
		high = new BinaryTree();
		quantity = 1;
	}

	// Getter Methods

	public Node getRoot() {
		return rootNode;
	}

	public BinaryTree getLow() {
		return low;
	}

	public Node getLowNode() {
		return low.getRoot();
	}

	public BinaryTree getHigh() {
		return high;
	}

	public Node getHighNode() {
		return high.getRoot();
	}

	public int getQuantity() {
		quantity = checkQuantity(this);
		return quantity;// inefficient ;
	}

	// Setter Methods These are blocked off due to lack of use
	/**
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
	
	
	public void attachLowBranch() 
	{
		//TODO: Complete This!
	} 
	
	public void attachHighBranch() 
	{
		//TODO: Complete This!
	} 

	public void add(Node e) {
		if ((e != null) && !e.isEmpty()) // if the node is null then there's no point
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

	public Comparable[] toArray() {
		// TODO: Complete to Array, May need to use arrayList

		return null;
	}

}
