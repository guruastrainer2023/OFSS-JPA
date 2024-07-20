package com.training.bean.pack4;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="ContactInfo2")
@Table(name="contactInfos20")
public class ContactInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", sequenceName ="seq23", allocationSize = 1)
	int contactId;
	
	@Column
	String email;
	
	@Column
	String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	Person person;
	
	
	public ContactInfo() {
		super();
	}
	public ContactInfo(String email, String phone) {
		super();
		this.email = email;
		this.phone = phone;
	
	}
	
	public ContactInfo(int contactId, String email, String phone ) {
		super();
		this.contactId = contactId;
		this.email = email;
		this.phone = phone;
		
	}
	
	
	public ContactInfo(int contactId, String email, String phone, Person person) {
		super();
		this.contactId = contactId;
		this.email = email;
		this.phone = phone;
		this.person = person;
	}
	
	
	public ContactInfo(String email, String phone, Person person) {
		super();
		this.email = email;
		this.phone = phone;
		this.person = person;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "ContactInfo [contactId=" + contactId + ", email=" + email + ", phone=" + phone + ", person=" + person
				+ "]";
	}
	
	
	
	
	
	
}
