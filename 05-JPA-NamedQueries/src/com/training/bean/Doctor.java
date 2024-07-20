package com.training.bean;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.NamedQueries;




@Entity
@Table(name="doctors10")

@NamedQueries(
		{
		@NamedQuery(name="findAll", query = "select d from Doctor d"),
		@NamedQuery(name="findById", query = "select d from Doctor d where d.id=:searchId"),
		@NamedQuery(name="updateFees", query = "update Doctor d set d.fees=d.fees+200"),
		@NamedQuery(name="deleteAboveFees", query = "delete from Doctor d where d.fees< :feesCutOff")
		
		}
)

public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", sequenceName ="seq27", allocationSize = 1)
	int id;
	
	String name;
	double fees;
	String gender;
	LocalDate practicingSince;
	
	public Doctor(int id, String name, double fees, String gender, LocalDate practicingSince) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
		this.gender = gender;
		this.practicingSince = practicingSince;
	}
	
	

	public Doctor(String name, double fees, String gender, LocalDate practicingSince) {
		super();
		this.name = name;
		this.fees = fees;
		this.gender = gender;
		this.practicingSince = practicingSince;
	}



	public Doctor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getPracticingSince() {
		return practicingSince;
	}

	public void setPracticingSince(LocalDate practicingSince) {
		this.practicingSince = practicingSince;
	}

	@Override
	public String toString() {
		return "\n Doctor [id=" + id + ", name=" + name + ", fees=" + fees + ", gender=" + gender + ", practicingSince="
				+ practicingSince + "]";
	}
	
	
	
}
