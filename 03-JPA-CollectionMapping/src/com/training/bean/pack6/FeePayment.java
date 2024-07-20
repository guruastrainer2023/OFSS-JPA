package com.training.bean.pack6;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FeePayment {
	
	@Column
	private String monthName;
	
	@Column
	private double feesPaid;
	
	public FeePayment(String monthName, double feesPaid) {
		super();
		this.monthName = monthName;
		this.feesPaid = feesPaid;
	}

	public FeePayment() {
		super();
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public double getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(double feesPaid) {
		this.feesPaid = feesPaid;
	}

	@Override
	public String toString() {
		return "\n FeePayment [monthName=" + monthName + ", feesPaid=" + feesPaid + "]";
	}
	
	
	
	
}
