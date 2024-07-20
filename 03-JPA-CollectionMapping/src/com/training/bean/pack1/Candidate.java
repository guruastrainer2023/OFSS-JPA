package com.training.bean.pack1;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="candidates10")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cand_id_seq3")
	@SequenceGenerator(name = "cand_id_seq3", sequenceName ="seq8", allocationSize = 1)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String city;
	
	@ElementCollection(targetClass = Double.class)
	@CollectionTable(name ="marks10")
	@OrderColumn(name = "idx")
	private Double[] marks;
	
	public Candidate(int id, String name, String city, Double[] marks) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.marks = marks;
	}
	public Candidate() {
		super();
	}
	
	
	public Candidate(int id) {
		super();
		this.id = id;
	}
	public Candidate(String name, String city, Double[] marks) {
		super();
		this.name = name;
		this.city = city;
		this.marks = marks;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double[] getMarks() {
		return marks;
	}
	public void setMarks(Double[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "\nCandidate [id=" + id + ", name=" + name + ", city=" + city + ", marks=" + Arrays.toString(marks) + "]";
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
		Candidate other = (Candidate) obj;
		return id == other.id;
	}
	
	

}
