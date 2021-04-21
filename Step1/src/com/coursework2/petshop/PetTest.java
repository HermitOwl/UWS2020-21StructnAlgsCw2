package com.coursework2.petshop;

import com.coursework2.dynamicdatatypes.*;

public class PetTest {
	//TODO complete these methods
	public static void add() 
	{
		
	}
	public static void remove() {}
	
	public static void find() {}
	
	public static void displayPetDetails(){}
	
	public static void displayInventory() {}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree pets;
		Node testnode = new Node(new Pet("C"));
		pets = new BinaryTree(testnode);
		testnode = new Node(new Pet("B"));
		pets.insertNode(testnode);

		testnode = new Node(new Pet("E"));
		pets.insertNode(testnode);
		testnode = new Node(new Pet("A"));
		pets.insertNode(testnode);
		testnode = new Node(new Pet("F"));
		pets.insertNode(testnode);
		testnode = new Node(new Pet("D"));
		pets.insertNode(testnode);
		
		System.out.println("Working");
		
		String input = "";
		boolean close = true;
		System.out.println("Testing");
		System.out.println("Root: "+pets.getRootNode().toString());
		System.out.println("Root-Left: "+pets.getRootNode().getBranchA().toString());
		System.out.println("Root-Left-Left: "+pets.getRootNode().getBranchA().getBranchA().toString());
		System.out.println("Root-Right: "+pets.getRootNode().getBranchB().toString());
		System.out.println("Root-Right-Left: "+pets.getRootNode().getBranchB().getBranchA().toString());
	//	System.out.println("Root Left:"+pets.getRootNode().getBranchA().getBranchB().toString()); //This is null, haven't added try catches for null yet
		System.out.println("Root-Right-Right: "+pets.getRootNode().getBranchB().getBranchB().toString());
		System.out.println("Test node quantity: "+BinaryTree.checkQuantity(pets.getRootNode()));
		System.out.println();
		System.out.println("Comparison Tests");
		//Equal Test because for some reason Node.Equals doesn't work yet
		System.out.println("compareTo Test P == P: " + (new Pet("P").compareTo(new Pet("P")) == 0));
		System.out.println("Equals Test P == P: " + (new Pet("P").equals(new Pet("P")))); // Compare to Works Equals doesn't
		System.out.println("Comparable.compareTo Test  P == D: " + (new Pet("P").compareTo(new Pet("D")) == 0));
		System.out.println("Comparable.compareTo Test  D (in pets) == D: " + (pets.getRootNode().getBranchB().getBranchA().getPayload().compareTo(new Pet("D")) == 0));
		System.out.println("Comparable.compareTo Test  D (in pets) == P: " + (pets.getRootNode().getBranchB().getBranchA().getPayload().compareTo(new Pet("P")) == 0));
		System.out.println();
		System.out.println();
		System.out.println("Node.equals Test  D (in pets) == D: " + (pets.getRootNode().getBranchB().getBranchA().equals(new Node( new Pet("D")))));
		System.out.println("Node.equals Test  D (in pets) == P: " + (pets.getRootNode().getBranchB().getBranchA().equals(new Node( new Pet("P")))));
		System.out.println();
		System.out.println("Comparison Tests");
		Node D = new Node(new Pet("D"));
		System.out.println("Contains D: "+ pets.contains(D));
		System.out.println("Contains P: "+ pets.contains(new Node(new Pet("P"))));
		//System.out.println("Contains \"D\""+ pets.contains(new Node()));// Returns null
	

	}

}
