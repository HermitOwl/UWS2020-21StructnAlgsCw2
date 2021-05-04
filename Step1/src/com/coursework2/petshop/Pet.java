package com.coursework2.petshop;

import java.util.ArrayList;

/**
 * @author James Agbotta
 *
 */
public class Pet implements Comparable<Pet> {
	// TODO: Complete all comments
	private String type;
	private ArrayList<Product> products;

	/**
	 * @param type
	 */
	public Pet(String type) {
		this.type = type;
		products = new ArrayList<Product>();
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
		return products.get(index);
	}

	/**
	 * @return
	 */
	public Product[] getProductList() {

		Product[] temp = new Product[products.size()];
		for (int i = 0; i < products.size(); i++) {
			temp[i] = products.get(i);
		}
		return temp;
	}

	/**
	 * @param index
	 * @return
	 */
	public Product removeProduct(int index) {
		return products.remove(index);
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

		for (Product p : products) {
			temp = temp + p.toString() + "\n";
		}
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
