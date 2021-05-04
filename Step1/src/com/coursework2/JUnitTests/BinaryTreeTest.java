package com.coursework2.JUnitTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.coursework2.dynamicdatatypes.BinaryTree;
import com.coursework2.dynamicdatatypes.Node;
//import 

class BinaryTreeTest {

	@Test
	void test() {
		BinaryTree testTree = new BinaryTree();
		testTree.add(new Node("Root"));
		assert(testTree.getRoot().getPayload()=="Root");
		assert(testTree.contains(new Node("Root")));
		assert(!testTree.contains(new Node("root"))); //Assuming ASCII /Unicode case sensitivity 
	
		//Testing add high
		testTree = new BinaryTree();
		for(int i =0; i <6; i++) 
		{
			testTree.add(new Node( i));
			testTree.add(new Node( i+4));
		}
		
		assert(testTree.getQuantity() == 10);
		assert((int)testTree.getHighNode().getPayload()==4);
		
		// adding low
		for(int i =0; i >-6; i--) // initially caused  stack overflow error because of poor execution
		{
			testTree.add(new Node(i));
		}
		
		
		assert(testTree.getQuantity() == 15); 
		assert((int)testTree.getLowNode().getPayload()==-1);
		System.out.println(testTree.stringUp()); //This should return contents in order
		
		System.out.println();
		//Randomised
		testTree = new BinaryTree();
		for(int i = 0 ; i < 40;i++) 
		{
			testTree.add(new Node( Math.round(Math.random()*100))); //
		}
		System.out.println(testTree.stringUp()); //This should return contents in order
		System.out.println("quanity: " +testTree.getQuantity());
		//Note: Tests return less than 39
		
		
		System.out.println();
		testTree = new BinaryTree();
		for(int i = 0 ; i < 10;i++) 
		{
			testTree.add(new Node(i)); //
		}
		
		BinaryTree testTree2 = new BinaryTree();
		
		
		do{
			testTree2.add(new Node((int) Math.round(Math.random()*100))); // will need to add Java.lang.ClassCastException to BinaryTree.addTree();
		}while(testTree2.getQuantity()<5);
		
		testTree.addTree(testTree2); //  Failed  with Java.lang.ClassCastException the 
		System.out.println(testTree.stringUp()); //This should return contents in order
		System.out.println("quanity: " +testTree.getQuantity());
		assert(testTree.getQuantity()==15);
		
		testTree.remove(new Node(5));
		System.out.println(testTree.stringUp()); //This should return contents in order
		System.out.println("quanity: " +testTree.getQuantity());
		assert(testTree.getQuantity()==14);
		
	}

}
