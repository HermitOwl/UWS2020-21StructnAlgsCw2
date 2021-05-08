package com.coursework2.dynamicdatatypes;

/**
 * @author James Agbotta
 *
 */
public class BinaryTree {

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
	 * 
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
	 * 
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

	public void add(Node node) {
		// if the node is null then there's no point
		if ((node != null) && !node.isEmpty()) {

			if ((rootNode != null) && !rootNode.isEmpty()) {
				if (rootNode.greaterThan(node)) {
					if (low != null) {
						if (low.getRoot().isEmpty())
							low = new BinaryTree(node);
						else
							low.add(node);
					} else {
						low = new BinaryTree(node);
					}
				} else if (rootNode.lessThan(node)) {
					if (high != null) {
						if (high.getRoot().isEmpty()) {
							high = new BinaryTree(node);
						} else
							high.add(node);
					} else {
						high = new BinaryTree(node);
					}

				}
			} else {

				rootNode = node;
			}

		}

	}

	/**This adds a subtree to the tree. 
	 * Assuming the subtree is already in order, the said subtree will be placed in the next available empty branch according to the magnitude of the root node's payload. 
	 *
	 * @param BinaryTree t
	 */
	public void addTree(BinaryTree t) {
		try {
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
		}catch (java.lang.ClassCastException e) 
		{
			System.out.println("Failed to add Tree, object missmatch");
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
	 * @param replacementNode
	 * @return
	 */
	public void findAndReplace(Node replacementNode) {
		if ((replacementNode != null) && !replacementNode.isEmpty())// if it's empty or null it will trigger true incorrectly
		{
			if ((rootNode != null) && !rootNode.isEmpty()) // if the root is null or empty, assume the tree is empty
			{
				if (rootNode.equals(replacementNode))
					rootNode = replacementNode;
				else if (rootNode.greaterThan(replacementNode)) {
					if (low != null)
						low.findAndReplace(replacementNode);
				} else if (rootNode.lessThan(replacementNode)) {
					if (high != null)
						high.findAndReplace(replacementNode);
				}
			}
		}

	}

	/**
	 * 
	 * @param searchNode
	 * @return
	 */

	public BinaryTree getTreeViaSearch(Node searchNode) {
		BinaryTree tempTree = new BinaryTree();

		if ((searchNode != null) && !searchNode.isEmpty())// if it's empty or null it will trigger true incorrectly
		{
			if ((rootNode != null) && !rootNode.isEmpty()) // if the root is null or empty, assume the tree is empty
			{
				if (rootNode.equals(searchNode))
					tempTree = this;
				else if (rootNode.greaterThan(searchNode)) {
					if (low != null)
						tempTree = low.getTreeViaSearch(searchNode);
				} else if (rootNode.lessThan(searchNode)) {
					if (high != null)
						tempTree = high.getTreeViaSearch(searchNode);
				}
			}
		}

		return tempTree;
	}

	/**
	 * 
	 * @param searchNode
	 * @return
	 */
	public Node remove(Node searchNode) {
		Node removed = new Node();
		BinaryTree tempTree = new BinaryTree();

		tempTree = this.getTreeViaSearch(searchNode);// Find the Node, If it's not there it will return a blank tree
		removed = tempTree.getRoot(); // set the Node to be returned
		this.replaceNode(searchNode, reduceTree(tempTree)); // Replace the current subtree with one where the node is removed

		return removed;
	}

	/**
	 * 
	 * @param subtree
	 * @return
	 */
	private BinaryTree reduceTree(BinaryTree subtree) {

		BinaryTree temp = new BinaryTree();
		if (subtree.getHigh() != null)
			temp = subtree.getHigh();
		if (subtree.getLow() != null)
			temp.addTree(subtree.getLow());
		return temp;
	}

	/**
	 * 
	 * @param searchNode
	 * @param replacement
	 */
	private void replaceNode(Node searchNode, BinaryTree replacement) {
		if ((searchNode != null) && !searchNode.isEmpty())// if it's empty or null it will trigger true incorrectly
		{
			if ((rootNode != null) && !rootNode.isEmpty()) {
				if (rootNode.equals(searchNode)) {
					this.high = replacement.getHigh();
					this.low = replacement.getLow();
					this.rootNode = replacement.getRoot();
				} else if (rootNode.greaterThan(searchNode)) {
					if (low != null)
						low.replaceNode(searchNode, replacement);
				} else if (rootNode.lessThan(searchNode)) {
					if (high != null)
						high.replaceNode(searchNode, replacement);
				}
			}

		}

	}

	/**This method uses an inorder traversal to list all the Node objects in the tree. 
	 * 
	 * @param subtree
	 * @return String
	 */
	public static String stringUp(BinaryTree subtree) {
		String temp = "";
		if ((subtree != null) && !subtree.getRoot().isEmpty()) {// if the node is empty, assume the rest of the tree is empty

			temp = temp + stringUp(subtree.getLow()) + "\n";
			temp = temp + subtree.getRoot().toString();
			temp = temp + stringUp(subtree.getHigh());
		}
		return temp;
	}

	/**This method applies the static StringUp() method directly to the tree itself rather than any unrelated tree or subtree.
	 * 
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
