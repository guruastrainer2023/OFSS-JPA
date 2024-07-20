package com.training.bean.pack3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="CarLoan3")
@Table(name="carloans30")
public class CarLoan extends Loan {
	
	@Column
	String carDetails;
	
	@Column
	String registeredState;
	
	public String getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(String carDetails) {
		this.carDetails = carDetails;
	}
	public String getRegisteredState() {
		return registeredState;
	}
	public void setRegisteredState(String registeredState) {
		this.registeredState = registeredState;
	}
	@Override
	public String toString() {
		return "CarLoan [carDetails=" + carDetails + ", registeredState="
				+ registeredState + ", toString()=" + super.toString() + "]";
	}
	
	

}
