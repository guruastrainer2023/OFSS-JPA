package com.training.bean.pack3;

import java.util.Set;
import java.util.TreeSet;

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
@Table(name="states")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_id_seq")
	@SequenceGenerator(name = "state_id_seq", sequenceName ="seq12", allocationSize = 1)
	private int id;
	
	@Column
	private String name;
	
	@ElementCollection
	@CollectionTable(name ="states_cityNames")
	
	private Set<String> cityNames;
	
	public State(String name) {
		super();
		this.name = name;
		this.cityNames=new TreeSet<>();
	}

	public State() {
		super();
		this.cityNames=new TreeSet<>();
	}
	
	
	
	public State(int id) {
		super();
		this.id = id;
	}

	public void addCityName(String cityName){
		this.cityNames.add(cityName);
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

	public Set<String> getCityNames() {
		return cityNames;
	}

	public void setCityNames(Set<String> cityNames) {
		this.cityNames = cityNames;
	}

	@Override
	public String toString() {
		return "\n State [id=" + id + ", name=" + name + ", cityNames=" + cityNames + "]";
	}
	
	
	
	
	

}
