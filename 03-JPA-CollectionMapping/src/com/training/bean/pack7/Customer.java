package com.training.bean.pack7;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Customer {
	
	@Column
	private String customerName;
	
	@Column
	private double balanceAmount;
	
	public Customer(String customerName, double balanceAmount) {
		super();
		this.customerName = customerName;
		this.balanceAmount = balanceAmount;
	}
	public Customer() {
		super();
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	@Override
	public String toString() {
		return "\nCustomer [customerName=" + customerName + ", balanceAmount=" + balanceAmount + "]";
	}
	
	
}
