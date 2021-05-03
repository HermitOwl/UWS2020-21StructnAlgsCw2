package com.coursework2.dynamicdatatypes;

/**
 * @author James Agbotta
 *
 */
public class BinaryTree {
	// TODO: Complete all comments
	/**
	 * Binary Tree
	 *
	 * @author James Agbotta
	 */
	private Node rootNode;
	private BinaryTree low;
	private BinaryTree high;
	private int quantity;

	/**
	 * BinaryTree() Constructor for the BinaryTree class
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
	 * BinaryTree(Node rootNode) Constructor for the BinaryTree class.
	 * 
	 * Sets the root node to the incoming parameter
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
	 * @param root
	 */
	public void setRoot(Node root) {
		rootNode = root;
	}

	/**
	 * getLowNode()
	 * 
	 * @return BinaryTree low : Returns the Branch (BinrayTree) with Nodes less than
	 *         the root Node
	 *
	 */
	public BinaryTree getLow() {
		return low;
	}

	/**
	 * getLowNode()
	 * 
	 * @return low.getRoot() : Returns the first Node less than the root Node
	 *
	 */

	public Node getLowNode() {
		return low.getRoot();
	}

	/**
	 * getHigh()
	 * 
	 * @return BinaryTree high - Returns the Branch (BinrayTree) with Nodes greater
	 *         than the root Node; the variable high;
	 *
	 */
	public BinaryTree getHigh() {
		return high;
	}

	/**
	 * getHighNode()
	 * 
	 * @return high.getRoot() - Returns the first node greater than the root Node
	 *
	 */
	public Node getHighNode() {
		return high.getRoot();
	}

	/**
	 * getQuantity() This method uses the checkQuantity(BinaryTree t) method on the
	 * tree it self and stores the integer value in the quantity variable;
	 * 
	 * @return int quantity - the quantity of the tree at the time of checking
	 */
	public int getQuantity() {
		quantity = checkQuantity(this);
		return quantity;// inefficient ;
	}

	/**
	 * add()
	 * 
	 * This method adds a node to the Binary tree. Test, first, if the current root
	 * is empty (and by extension the tree) the node will replace the empty root
	 * node. Otherwise the node will be added to the low or high tree depending on
	 * it's difference to the rootNode.
	 * 
	 * @param Node e - the node to be added;
	 */

	public void add(Node e) {
		// if the node is null then there's no point
		if ((e != null) && !e.isEmpty()) {

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

	/**
	 * 
	 * @param BinaryTree t
	 */

	public void addTree(BinaryTree t) {
		if ((t != null) && !t.getRoot().isEmpty()) {
			if ((rootNode != null) && !rootNode.isEmpty()) {
				{
					if (rootNode.greaterThan(t.getRoot())) {
						if (low != null) {
							if (low.getRoot().isEmpty()) {
								low = t;
							} else
								low.addTree(t);
						}
					} else if (rootNode.lessThan(t.getRoot())) {
						if (high != null) {
							if (high.getRoot().isEmpty()) {
								high = t;
							} else
								high.addTree(t);
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param t
	 * @return
	 */

	public static int checkQuantity(BinaryTree t) {
		int temp = 0;
		if ((t != null) && !t.getRoot().isEmpty()) {// if the node is empty, assume the rest of the tree is empty
			temp++;
			temp += checkQuantity(t.getLow());
			temp += checkQuantity(t.getHigh());
		}
		return temp;
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
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

	/**
	 * 
	 * @param e
	 * @return
	 */
	public Node find(Node e) {
		Node temp = new Node();
		if ((e != null) && !e.isEmpty())// if it's empty or null it will trigger true incorrectly
		{
			if ((rootNode != null) && !rootNode.isEmpty()) // if the root is null or empty, assume the tree is empty
			{
				if (rootNode.equals(e))
					temp = rootNode;
				else if (rootNode.greaterThan(e)) {
					if (low != null)
						temp = low.find(e);
				} else if (rootNode.lessThan(e)) {
					if (high != null)
						temp = high.find(e);
				}
			}
		}

		return temp;
	}

	/**
	 * public void findandReplace(Node e) This method is a patch to fix an issue I
	 * wouldn't have if only I used Current and Parent Nodes
	 * 
	 * @param e
	 * @return
	 */
	public void findAndReplace(Node e) {
		if ((e != null) && !e.isEmpty())// if it's empty or null it will trigger true incorrectly
		{
			if ((rootNode != null) && !rootNode.isEmpty()) // if the root is null or empty, assume the tree is empty
			{
				if (rootNode.equals(e))
					rootNode = e;
				else if (rootNode.greaterThan(e)) {
					if (low != null)
						low.findAndReplace(e);
				} else if (rootNode.lessThan(e)) {
					if (high != null)
						high.findAndReplace(e);
				}
			}
		}

	}

	/**
	 * 
	 * @param e
	 * @return
	 */

	public BinaryTree getTreeViaSearch(Node e) {
		BinaryTree tempTree = new BinaryTree();

		if ((e != null) && !e.isEmpty())// if it's empty or null it will trigger true incorrectly
		{
			if ((rootNode != null) && !rootNode.isEmpty()) // if the root is null or empty, assume the tree is empty
			{
				if (rootNode.equals(e))
					tempTree = this;
				else if (rootNode.greaterThan(e)) {
					if (low != null)
						tempTree = low.getTreeViaSearch(e);
				} else if (rootNode.lessThan(e)) {
					if (high != null)
						tempTree = high.getTreeViaSearch(e);
				}
			}
		}

		return tempTree;
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public Node remove(Node e) {
		Node removed = new Node();
		BinaryTree tempTree = new BinaryTree();

		tempTree = this.getTreeViaSearch(e);// Find the Node, If it's not there it will return a blank tree
		removed = tempTree.getRoot(); // set the Node to be returned
		this.replaceNode(e, reduceTree(tempTree)); // Replace the current subtree with one where the node is removed

		return removed;
	}

	/**
	 * 
	 * @param BinaryTree t
	 * @return
	 */
	private BinaryTree reduceTree(BinaryTree t) {

		BinaryTree temp = new BinaryTree();
		if (t.getHigh() != null)
			temp = t.getHigh();
		if (t.getLow() != null)
			temp.addTree(t.getLow());
		return temp;
	}

	/**
	 * 
	 * @param e
	 * @param replacement
	 */
	private void replaceNode(Node e, BinaryTree replacement) {
		if ((e != null) && !e.isEmpty())// if it's empty or null it will trigger true incorrectly
		{
			if ((rootNode != null) && !rootNode.isEmpty()) {
				if (rootNode.equals(e)) {
					this.high = replacement.getHigh();
					this.low = replacement.getLow();
					this.rootNode = replacement.getRoot();
				} else if (rootNode.greaterThan(e)) {
					if (low != null)
						low.replaceNode(e, replacement);
				} else if (rootNode.lessThan(e)) {
					if (high != null)
						high.replaceNode(e, replacement);
				}
			}

		}

	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	public static String stringUp(BinaryTree t) {
		String temp = "";
		if ((t != null) && !t.getRoot().isEmpty()) {// if the node is empty, assume the rest of the tree is empty

			temp = temp + stringUp(t.getLow()) + "\n";
			temp = temp + t.getRoot().toString();
			temp = temp + stringUp(t.getHigh());
		}
		return temp;
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	public String stringUp() {
		return stringUp(this);
	}

	@Override
	public String toString() {
		return "Binary Tree, contains: " + getQuantity() + "nodes";
	}
}
