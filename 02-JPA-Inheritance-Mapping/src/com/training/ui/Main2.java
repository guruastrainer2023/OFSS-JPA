package com.training.ui;

import java.util.Date;

import javax.persistence.EntityManager;

import com.training.bean.pack2.CarLoan;
import com.training.bean.pack2.HomeLoan;
import com.training.bean.pack2.Loan;

import com.training.util.JPAUtil;




public class Main2 {
	
	static void insert(){
		Loan loan=new Loan();
		loan.setCustomerName("John");
		loan.setLoanAmt(10000);
		loan.setLoanDate(new Date());
		;
		
		CarLoan carLoan=new CarLoan();
		carLoan.setCustomerName("Karthik");
		carLoan.setLoanAmt(60000);
		carLoan.setLoanDate(new Date());
		carLoan.setCarDetails("KL-31 2055");
		carLoan.setRegisteredState("Kerala");
	
		
		HomeLoan homeLoan=new HomeLoan();
		homeLoan.setCustomerName("Santhosh");
		homeLoan.setLoanAmt(100000);
		homeLoan.setLoanDate(new Date());
		homeLoan.setHomeAddress("F2..Wilson Garden..Bangalore");
		homeLoan.setOwnedBy("Santhosh");
		
		
		
		EntityManager em = JPAUtil.getEntityManager("PU");
		
		
		
		em.getTransaction().begin();
		
		em.persist(loan);
		em.persist(carLoan);
		em.persist(homeLoan);
		
		em.getTransaction().commit();
		
		System.out.println("Loan Objects Saved");
		
		
		
		
	}

	public static void main(String[] args) {
		
		
		insert();

	}

}
