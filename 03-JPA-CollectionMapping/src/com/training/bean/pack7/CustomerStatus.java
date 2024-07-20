package com.training.bean.pack7;

import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="CustomerStatus")
public class CustomerStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cs_id_seq")
	@SequenceGenerator(name = "cs_id_seq", sequenceName ="seq16", allocationSize = 1)
	private int id;
	
	@Column
	private String regionName;
	
	@ElementCollection
    @CollectionTable(name = "CustomerStatusMap_10") 
    @MapKeyColumn(name = "status")
  	private Map<String, Customer> statusMap;
	
	public CustomerStatus(int id, String regionName, Map<String, Customer> statusMap) {
		super();
		this.id = id;
		this.regionName = regionName;
		this.statusMap = statusMap;
	}

	public CustomerStatus(String regionName, Map<String, Customer> statusMap) {
		super();
		this.regionName = regionName;
		this.statusMap = statusMap;
	}

	public CustomerStatus(int id) {
		super();
		this.id = id;
	}

	public CustomerStatus() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Map<String, Customer> getStatusMap() {
		return statusMap;
	}

	public void setStatusMap(Map<String, Customer> statusMap) {
		this.statusMap = statusMap;
	}

	@Override
	public String toString() {
		return "\nCustomerStatus [id=" + id + ", regionName=" + regionName + ", statusMap=" + statusMap + "]";
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
		CustomerStatus other = (CustomerStatus) obj;
		return id == other.id;
	}
	
	
	
}
