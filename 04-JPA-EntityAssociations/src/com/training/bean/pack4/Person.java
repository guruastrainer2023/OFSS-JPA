package com.training.bean.pack4;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity(name="Person2")
@Table(name="persons20")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", sequenceName ="seq24", allocationSize = 1)
	int personId;
	
	@Column
	String personName;
	
	@Column
	LocalDate dateOfBirth;
	
	@Column
	char gender;
	
	
	
	public Person() {
		super();
	}
	public Person(String personName, LocalDate dateOFBirth, char gender) {
		super();
		this.personName = personName;
		this.dateOfBirth = dateOFBirth;
		this.gender = gender;
		
	}
	
	
	public Person(int personId, String personName, LocalDate dateOfBirth, char gender) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOFBirth) {
		this.dateOfBirth = dateOFBirth;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + "]";
	}
	
	
	
}
