package com.training.bean.pack5;


import java.time.LocalDate;
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
@Table(name="Bills10")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_id_seq")
	@SequenceGenerator(name = "bill_id_seq", sequenceName ="seq14", allocationSize = 1)
	private int id;
	
	@Column
	private String customerName;
	
	@Column
	private LocalDate billingDate;
	
	@ElementCollection
    @CollectionTable(name = "BillItems10") 
	@OrderColumn(name="index_pos")
    private List<BillItem> billItems;
	
	public Bill(String customerName, LocalDate billingDate) {
		super();
		this.customerName = customerName;
		this.billingDate = billingDate;
		this.billItems=new LinkedList<BillItem>();
	}

	public Bill() {
		super();
		this.billItems=new LinkedList<BillItem>();
	}
	
	
	
	public Bill(int id) {
		super();
		this.id = id;
	}

	public void addBillItem(BillItem billItem){
		this.billItems.add(billItem);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}

	@Override
	public String toString() {
		return "\n Bill [id=" + id + ", customerName=" + customerName + ", billingDate=" + billingDate + ", billItems="
				+ billItems + "]";
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
		Bill other = (Bill) obj;
		return id == other.id;
	}
	
	
	
}
