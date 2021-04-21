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
		
		System.out.println("#Testing#");
		System.out.println("##New tree##");
		BinaryTree petTree = new BinaryTree();
		System.out.println("\tTree initialised:  " +petTree.getRoot().toString()); 
		System.out.println("");
		System.out.println("##New tree (include Pet type 'D')##");
		Pet pet = new Pet("D");
		petTree = new BinaryTree(new Node(pet));
		System.out.println("\tTree initialised:  " +petTree.getRoot().toString()); 
	
		System.out.println("");
		System.out.println("##Same Tree (Add Pet type 'A')##");
		pet = new Pet("A");
		petTree.add(new Node(pet));;
		System.out.println("\tTree initialised:  " +petTree.getRoot().toString()); 
		System.out.println("\t\t low:  " +petTree.getLowNode().toString()); 

		pet = new Pet("E");
		petTree.add(new Node(pet));;
		System.out.println("\t\t high:  " +petTree.getHighNode().toString()); 
		
		pet = new Pet("D");
		petTree.add(new Node(pet));;
		System.out.println("\t where new node= root:  " +petTree.getRoot().toString());
		System.out.println("\t petTree quanity:  " +petTree.getQuantity());
		
		System.out.println("");
		System.out.println("##New Tree (adding list of nodes to tree')##");
		petTree = new BinaryTree();
		Node[] pets = {new Node(new Pet("B")),new Node(new Pet("D")),new Node( new Pet("C")), new Node(new Pet("A")), new Node(new Pet("F")), new Node(new Pet("E")), new Node(new Pet("G")), new Node(new Pet("J")), new Node(new Pet("H")), new Node(new Pet("I"))};
	
		for(int i =0 ; i < pets.length; i++) 
		{
			petTree.add(pets[i]);
		}
		System.out.println("Does petTree Contain: A "+petTree.contains(new Node(new Pet("A"))));
		System.out.println("Does petTree Contain: F "+petTree.contains(new Node(new Pet("F")))); // Why? Will need to add inorder traversal.
		System.out.println("Does petTree Contain: P "+petTree.contains(new Node(new Pet("P"))));
		
	}

}
