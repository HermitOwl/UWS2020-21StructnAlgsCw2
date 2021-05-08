package com.coursework2.dynamicdatatypes;

public class LinkedList {

	private Node head;
	private LinkedList rest;// Because recursion is easier for me to understand for some reason

	private int size;

	public LinkedList() {
		head = new Node();

		rest = null;
		size = 0;
	}

	public LinkedList(Comparable payload) {
		this.head = new Node(payload);

		rest = new LinkedList();

		size = 1;
	}

	public LinkedList(Comparable payload, Node previous) {
		this.head = new Node(payload);

		rest = new LinkedList();

		size = 1;
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
						size++;
					}
				}
			} else {
				head = new Node(payload);
				rest = new LinkedList();
				size++;
			}

		}

	}

	public Comparable getHead() {
		return head.getPayload();
	}

	protected Node getHeadNode() {
		return head;
	}

	public LinkedList getRest() {
		return rest;
	}

	public Comparable get(int index) {
		Comparable temp;
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		if (index == 0) {
			temp = head.getPayload();
		} else
			temp = rest.get(index - 1);

		return temp;
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
		Comparable[] temp = new Comparable[size];
		Comparable[] restTemp;
		if (rest != null) {

			if ((!head.isEmpty()) && (head != null)) {

				temp[0] = head.getPayload();

				restTemp = rest.toArray();
				for (int i = 0; i < rest.size(); i++) {
					temp[i + 1] = restTemp[i];
				}

			}
		}

		return temp;

	}

	public Comparable remove(int index) {
//TODO: fix the node removal
		Comparable temp;
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();// borrowing the exception to prevent poor index calls

		if (index == 0) {
			temp = head.getPayload();
			this.replaceElement(temp, reduceList(this.getListFrom(temp)));
			size--;
		} else {
			temp = rest.remove(index - 1);
			size--;
		}
		

		return temp;

	}
	
	
	
	private LinkedList getListFrom(Comparable payLoad) 
	{
		LinkedList templist = new LinkedList();
		if(payLoad != null) {
			if((head != null) && !head.isEmpty()) {
				if(head.getPayload().equals(payLoad)) 
				{
					templist = this;
				
				}else 
				{
					templist = rest.getListFrom(payLoad);
				}
			}
		}
		
		return templist;
	}

	public boolean remove(Comparable payload) {
		// TODO: complete and fix the node removal
		boolean temp = this.contains(payload);
		if(temp) {
			this.replaceElement(payload, reduceList(this.getListFrom(payload)));
			size--;
		}
		

		return temp;

	}

	private LinkedList reduceList(LinkedList list) {
		LinkedList temp = new LinkedList();
		if (rest != null)
			temp = rest;
		return temp;
	}

	private void replaceElement(Comparable searchTerm, LinkedList replacement) {
		if (searchTerm != null) {
			if ((head != null) && !head.isEmpty()) {
				if (head.getPayload().equals(searchTerm)) {
					this.rest = replacement.getRest();
					this.head = replacement.getHeadNode();
				} else {
					if(rest != null) {
						rest.replaceElement(searchTerm, replacement);
					}

				}
			}
		}

	}

	public static int checkLength(LinkedList l) {
		int temp = 0;
		if ((l != null) && !l.getHeadNode().isEmpty()) {
			temp++;
			temp += checkLength(l.getRest());
		}
		return temp;
	}

	public int size() {
		return size;
	}

}
