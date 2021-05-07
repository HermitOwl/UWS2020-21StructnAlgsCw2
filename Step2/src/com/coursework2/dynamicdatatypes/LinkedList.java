package com.coursework2.dynamicdatatypes;

public class LinkedList {

	private Node head;
	private LinkedList rest;// Because recursion is easier for me to understand for some reason
	private Node current;
	private Node previous;
	private int length;

	public LinkedList() {
		head = new Node();
		current = head;
		previous = new Node();
		rest = null;
		length = 0;
	}

	public LinkedList(Comparable payload) {
		this.head = new Node(payload);
		current = head;
		rest = new LinkedList();
		previous = new Node();
		length = 1;
	}

	public LinkedList(Comparable payload, Node previous) {
		this.head = new Node(payload);
		current = head;
		rest = new LinkedList();
		this.previous = previous;
		length = 1;
	}

	public void add(Comparable payload) {
		if (payload != null) // if there's nothing there, what's the point?
		{
			if ((!head.isEmpty()) && (head != null)) {
				if (!head.getPayload().equals(payload)) {
					if (rest != null) {
						if (rest.getHeadNode().isEmpty()) {
							rest = new LinkedList(payload, head);

						} else {
							rest.add(payload);
						}
						length++;
					}
				}
			} else {
				head = new Node(payload);
				rest = new LinkedList();
				length++;
			}

		}

	}

	public Comparable getHead() {
		return head.getPayload();
	}

	protected Node getHeadNode() {
		return head;
	}

	public Comparable getCurrent() {
		return current.getPayload();
	}

	public Comparable getPrevious() {
		return previous.getPayload();
	}

	public LinkedList getRest() {
		return rest;
	}

	public boolean contains(Comparable payload) {
		boolean temp = false;
		if (payload != null) {
			if ((!head.isEmpty()) && (head != null)) {
				/*
				 * 
				 * if(head.getPayload().equals(payload)) { temp = true; } else { temp =
				 * rest.contains(payload); }
				 */
				temp = (head.getPayload().equals(payload)) || rest.contains(payload);
			}
		}
		return temp;
	}

	public Comparable[] toArray() {
		Comparable[] temp = new Comparable[length];
		Comparable[] restTemp;
		if (rest != null) {

			if ((!head.isEmpty()) && (head != null)) {

				temp[0] = head.getPayload();

				restTemp = rest.toArray();
				for (int i = 0; i < rest.getLength(); i++) {
					temp[i + 1] = restTemp[i];
				}

			}
		}

		return temp;

	}

	public Comparable remove(int index) {
//TODO: fix the node removal
		Comparable temp;
		if (index < 0 || index >= length)
			throw new NullPointerException();//borrowing the exception to  prevent poor index calls

		if (index == 0) {
			temp = head.getPayload();
			this.remove(temp);
			length--;
		} else 
			temp = rest.remove(index - 1);
		

		return temp;

	}

	public boolean remove(Comparable payload) {
		//TODO: complete and fix the node removal
		boolean temp =  false;

		
		
		return temp;

	}
	
	private LinkedList reduceList(LinkedList list) 
	{
		LinkedList temp =  new LinkedList();
		if(rest!=null)
		temp = rest;
		return temp;
	}
	


	public static int checkLength(LinkedList l) {
		int temp = 0;
		if ((l != null) && !l.getHeadNode().isEmpty()) {
			temp++;
			temp += checkLength(l.getRest());
		}
		return temp;
	}

	public int getLength() {
		return length;
	}

}
