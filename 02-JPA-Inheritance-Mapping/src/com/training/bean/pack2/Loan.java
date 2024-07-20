package com.training.bean.pack2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="Loan2")
@Table(name="loans20")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class  Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_id_seq2")
	@SequenceGenerator(name = "loan_id_seq2", sequenceName ="seq6", allocationSize = 1)
	int loanId;
	
	@Column
	String customerName;
	
	@Column
	double loanAmt;
	
	@Column
	@Temporal(TemporalType.DATE)
	Date loanDate;
	
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", customerName=" + customerName
				+ ", loanAmt=" + loanAmt + ", loanDate=" + loanDate + "]";
	}
	
	

}
