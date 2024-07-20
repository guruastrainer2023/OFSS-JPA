package com.training.bean.pack5;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BillItem {
	
	@Column
	private int SlNo;
	
	@Column
	private String productName;
	
	@Column
	private int quantity;
	
	@Column
	private double price;
	
	public BillItem(int slNo, String productName, int quantity, double price) {
		super();
		SlNo = slNo;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public BillItem() {
		super();
	}
	
	public int getSlNo() {
		return SlNo;
	}
	public void setSlNo(int slNo) {
		SlNo = slNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "\n BillItem [SlNo=" + SlNo + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	
}
