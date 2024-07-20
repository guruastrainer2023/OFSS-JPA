package com.training.bean.pack6;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="FeeDetails")
public class FeeDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fd_id_seq")
	@SequenceGenerator(name = "fd_id_seq", sequenceName ="seq15", allocationSize = 1)
	private int id;
	
	@Column
	private double feeAmount;
	
	@ElementCollection
	@CollectionTable (name = "FeeDetails_Payments10")
	private Set<FeePayment> payments;
	
	public FeeDetail(int id, double feeAmount, Set<FeePayment> payments) {
		super();
		this.id = id;
		this.feeAmount = feeAmount;
		this.payments = payments;
	}

	public FeeDetail(int id) {
		super();
		this.id = id;
	}

	public FeeDetail(double feeAmount, Set<FeePayment> payments) {
		super();
		this.feeAmount = feeAmount;
		this.payments = payments;
	}
	
	

	
	public FeeDetail() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(double feeAmount) {
		this.feeAmount = feeAmount;
	}

	public Set<FeePayment> getPayments() {
		return payments;
	}

	public void setPayments(Set<FeePayment> payments) {
		this.payments = payments;
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
		FeeDetail other = (FeeDetail) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "\n FeeDetail [id=" + id + ", feeAmount=" + feeAmount + ", payments=" + payments + "]";
	}
	
	
	
}
