package com.coursework2.dynamicdatatypes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {
	LinkedList testlist= new LinkedList();
	LinkedList testlist2;
	
	@Test
	void initTest() {
		
		 testlist2= new LinkedList(5);
		assert((int)testlist2.getHead() ==5); //cast int because Comparable isn't type set
		assertNotNull(testlist);
		
		
	}
	
	@Test
	void addTest() 
	{
		testlist2= new LinkedList(5);
		testlist.add(1);
		assertEquals(1, (int)testlist.getHead());
		assertEquals(1, testlist.size());
		testlist.add(1);
		assertEquals(1, testlist.size());//initial error, length not incrimented ,
//		next error (duplicating entries)
		
		
		testlist2.add(2);
		testlist2.add(1);
		//Test if the literal count matches the 
		assertEquals(LinkedList.checkLength(testlist2),testlist2.size());
	    
	}
	@Test 
	void containsTest() 
	{
		//testlist2 currently contains 5,2 and 1 in that order;
		testlist2= new LinkedList(5);
		testlist2.add(2);
		testlist2.add(1);
		assertFalse(testlist.contains(1));
		assertTrue(testlist2.contains(1));
	}
	
	@Test
	void arrayTest() 
	{
		//
		int[] arrayTest = {1,2,3,4,5,6,7,8,9,10};
		int[] listTest;
		testlist = new LinkedList();
		for(int i = 0; i< arrayTest.length; i++)
			testlist.add(arrayTest[i]);
		
		
		assertEquals(arrayTest.length,LinkedList.checkLength(testlist));
		assertEquals(arrayTest.length,testlist.size());
		listTest = new int[testlist.size()];
		for(int i =0; i < listTest.length; i++)
			listTest[i] = (int) testlist.toArray()[i]; //This has to be done because LinkedList.toArray() returns Comparable[]
		assertArrayEquals(arrayTest,listTest); 
		
	}
	
	@Test
	void removeTest() 
	{
		int[] arrayTest = {1,2,3,4,5,6,7,8,9,10};
		int[] listTest;
		testlist = new LinkedList();
		for(int i = 0; i< arrayTest.length; i++)
			testlist.add(arrayTest[i]);
		
		assertEquals(LinkedList.checkLength(testlist),testlist.size());
		assertEquals(3,testlist.remove(2));
		assertEquals(LinkedList.checkLength(testlist),testlist.size());
		testlist.remove(2);
		assertEquals(arrayTest.length-2,testlist.size());
		
		testlist.remove((Comparable) 2);
		assertEquals(arrayTest.length-3,testlist.size());
		
		assertThrows(ArrayIndexOutOfBoundsException.class,()->{testlist.remove(-1);});
	
	}
	
	void toArrayTest() 
	{
		int[] arrayTest = {1,2,3,4,5,6,7,8,9,10};
		int[] listTest;
		testlist = new LinkedList();
		for(int i = 0; i< arrayTest.length; i++)
			testlist.add(arrayTest[i]);
		testlist.remove(1);
		
	}
	

}
