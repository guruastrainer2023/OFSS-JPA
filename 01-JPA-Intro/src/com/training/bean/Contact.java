package com.training.bean;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="contacts")
public class Contact {
	
	
	@Id 
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id_seq")
	@SequenceGenerator(name = "contact_id_seq", sequenceName ="seq2", allocationSize = 1)
	
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	
	
	public Contact(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public Contact(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public Contact(int id) {
		super();
		this.id = id;
	}


	public Contact() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "\nContact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return id == other.id;
	}
	
	

}
