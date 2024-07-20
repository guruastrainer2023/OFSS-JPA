package com.training.bean.pack3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="HomeLoan3")
@Table(name="homeloans30")
public class HomeLoan extends Loan{
	
	@Column
	String homeAddress;
	
	@Column
	String ownedBy;
	
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
	@Override
	public String toString() {
		return "HomeLoan [homeAddress=" + homeAddress + ", ownedBy=" + ownedBy
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
