package com.coursework2.petshop;

public class Product {

	private String productID;
	private String productName;
	private int stockQuantity;

	public Product() {
		productID = "";
		productName = "";
		stockQuantity = 0;
	}

	public Product(String productID, String productName, int stockQuantity) {
		this.productID = productID;
		this.productName = productName;
		this.stockQuantity = stockQuantity;
	}

	public String getID() {
		return productID;
	}

	public String getName() {
		return productID;
	}

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
}
