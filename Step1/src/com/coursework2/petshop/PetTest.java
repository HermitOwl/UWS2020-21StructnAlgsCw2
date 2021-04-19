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
		testnode = new Node(new Pet("D"));
		pets.insertNode(testnode);
		testnode = new Node(new Pet("E"));
		pets.insertNode(testnode);
		testnode = new Node(new Pet("A"));
		pets.insertNode(testnode);
		testnode = new Node("F");
		pets.insertNode(testnode);
		
		System.out.println("Working");
		
		String input = "";
		boolean close = true;
		System.out.println("Root "+pets.getRootNode().toString());
		System.out.println("Root Left:"+pets.getRootNode().getBranchA().toString());
		System.out.println("Root Right:"+pets.getRootNode().getBranchB().toString());
		System.out.println("Test node quantity: "+BinaryTree.checkQuantity(pets.getRootNode()));
		
	//	do
	//	{
			
	//	}while(close);
	

	}

}
