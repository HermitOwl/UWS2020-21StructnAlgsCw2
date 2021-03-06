package com.coursework2.petshop;

/**
 * @author James Agbotta
 *
 */
public class Product implements Comparable<Product> {
	private String productID;
	private String productName;
	private int stockQuantity;

	/**
	 * 
	 */
	public Product() {
		productID = "";
		productName = "";
		stockQuantity = 0;
	}

	/**
	 * @param productID
	 * @param productName
	 * @param stockQuantity
	 */
	public Product(String productID, String productName, int stockQuantity) {
		this.productID = productID;
		this.productName = productName;
		this.stockQuantity = stockQuantity;
	}

	/**
	 * @return
	 */
	public String getID() {
		return productID;
	}

	/**
	 * @return
	 */
	public String getName() {
		return productID;
	}

	/**
	 * @return
	 */
	public int getQuantity() {
		return stockQuantity;
	}

	public void setID(String productID) {
		this.productID = productID;
	}

	public void setName(String productName) {
		this.productName = productName;

	}

	public void setQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "" + productID + ": \t " + productName + "\n -> stockQuantity " + stockQuantity;
	}

	@Override
	public int compareTo(Product o) {
		return compareID(o) + compareName(o);
	}

	public int compareID(Product o) {
		return productID.compareTo(o.getID());
	}

	public int compareName(Product o) {
		return productName.compareTo(o.productName);
	}
}
