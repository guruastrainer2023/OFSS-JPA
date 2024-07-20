package com.training.bean.pack2;

import java.util.LinkedList;
import java.util.List;
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
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_id_seq")
	@SequenceGenerator(name = "cat_id_seq", sequenceName ="seq11", allocationSize = 1)
	private int id;
	
	@Column
	private String categoryName;
	
	@ElementCollection
	@CollectionTable(name ="category_technologies_10")
	@OrderColumn(name = "idx")
	private List<String> technologyNames;
	
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
		this.technologyNames=new LinkedList<>();
	}

	public Category() {
		super();
		this.technologyNames=new LinkedList<>();
	}
	
	
	
	public Category(int id) {
		super();
		this.id = id;
	}

	public void add(String technologyName){
		this.technologyNames.add(technologyName);
	}
	
	public void remove(String technologyName) {
		this.technologyNames.remove(technologyName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getTechnologyNames() {
		return technologyNames;
	}

	public void setTechnologyNames(List<String> technologyNames) {
		this.technologyNames = technologyNames;
	}

	@Override
	public String toString() {
		return "\nCategory [id=" + id + ", categoryName=" + categoryName + ", technologyNames=" + technologyNames + "]";
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
		Category other = (Category) obj;
		return id == other.id;
	}
	
	
	
}
