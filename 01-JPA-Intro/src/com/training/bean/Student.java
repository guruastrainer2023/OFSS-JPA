package com.training.bean;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="students30")

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roll_id_seq")
	@SequenceGenerator(name = "roll_id_seq", sequenceName ="seq2", allocationSize = 1)
	
	private int rollNumber;
	
	@Column
	private String name;
	
	@Column
	private int marks;
	
	@Embedded
	private Address address;

	public Student(int rollNumber, String name, int marks, Address address) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.marks = marks;
		this.address = address;
	}

	public Student(String name, int marks, Address address) {
		super();
		this.name = name;
		this.marks = marks;
		this.address = address;
	}

	public Student(int rollNumber, String name, int marks) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.marks = marks;
	}
	
	

	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public Student(int rollNumber) {
		super();
		this.rollNumber = rollNumber;
	}

	
	
	public Student() {
		super();
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "\nStudent [rollNumber=" + rollNumber + ", name=" + name + ", marks=" + marks + ", address=" + address
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(rollNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return rollNumber == other.rollNumber;
	}
	
	

}
