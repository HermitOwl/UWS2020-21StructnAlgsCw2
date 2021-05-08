package com.coursework2.petshop;

import java.util.ArrayList;

import com.coursework2.dynamicdatatypes.LinkedList;

/**
 * @author James Agbotta
 *
 */
public class Pet implements Comparable<Pet> {
	private String type;
	private LinkedList products;

	/**
	 * @param type
	 */
	public Pet(String type) {
		this.type = type;
		products = new LinkedList();
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param p
	 */
	public void addProduct(Product p) {
		products.add(p);
	}

	/**
	 * @param index
	 * @return
	 */
	public Product getProduct(int index) {
		return (Product) products.get(index);
	}

	/**
	 * @return
	 */
	public Product[] getProductList() {

		Product[] temp = new Product[products.size()];
		for (int i = 0; i < products.size(); i++) {
			temp[i] = (Product)products.get(i);
		}
		return temp;
	}

	/**
	 * @param index
	 * @return
	 */
	public Product removeProduct(int index) {
		return (Product)products.remove(index);
	}

	/**
	 * @param p
	 * @return
	 */
	public boolean removeProduct(Product p) {
		return products.remove(p);
	}

	/**
	 *
	 */
	public String toString() {
		return "Pet type: " + type;
	}

	/**
	 * @return
	 */
	public String toDetailedString() {
		String temp = "Pet type: " + type + "\n Products available:\n";

		for(int i = 0; i > products.size(); i++)
			temp = temp + products.get(i).toString() + "\n";
		
		return temp;

	}

	/**
	 *
	 */
	@Override
	public int compareTo(Pet o) {
		return this.type.compareTo(o.getType());
	}

}
