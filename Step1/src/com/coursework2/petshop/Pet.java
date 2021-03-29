package com.coursework2.petshop;

public class Pet implements Comparable {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() 
	{
		return "Pet type: " + type;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
