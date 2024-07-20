package com.training.bean.pack1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="CarLoan1")
@DiscriminatorValue("CL")
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
