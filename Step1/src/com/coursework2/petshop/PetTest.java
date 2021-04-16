package com.coursework2.petshop;

import com.coursework2.dynamicdatatypes.*;

public class PetTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree pets;
		Node testnode = new Node(new Pet("Dog"));
		pets = new BinaryTree(testnode);
		testnode = new Node(new Pet("Cat"));
		pets.insertNode(testnode);
		System.out.println("Working");
		
		String input = "";
		boolean close = true;
	//	do
	//	{
			
	//	}while(close);
	

	}

}
