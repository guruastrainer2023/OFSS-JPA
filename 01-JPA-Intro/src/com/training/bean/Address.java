package com.training.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column
	private String doorNumber;
	
	@Column(name="street")
	private String streetName;
	
	@Column(name="area")
	private String areaName;
	
	@Column
	private String city;
	
	@Column
	private String pincode;
	
	
	public Address(String doorNumber, String streetName, String areaName, String city, String pincode) {
		super();
		this.doorNumber = doorNumber;
		this.streetName = streetName;
		this.areaName = areaName;
		this.city = city;
		this.pincode = pincode;
	}
	public Address() {
		super();
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", streetName=" + streetName + ", areaName=" + areaName + ", city="
				+ city + ", pincode=" + pincode + "]";
	}
	
	

}
