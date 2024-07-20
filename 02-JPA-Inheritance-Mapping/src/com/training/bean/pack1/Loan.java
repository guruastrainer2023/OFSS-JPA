package com.training.bean.pack1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
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


@Entity(name="Loan1")
@Table(name="loans10")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name = "loan_Type")
@DiscriminatorValue("L")
public class  Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_id_seq1")
	@SequenceGenerator(name = "loan_id_seq1", sequenceName ="seq2", allocationSize = 1)
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
