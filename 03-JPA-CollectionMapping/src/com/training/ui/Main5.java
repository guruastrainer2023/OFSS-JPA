package com.training.ui;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.training.bean.pack3.State;
import com.training.bean.pack5.Bill;
import com.training.bean.pack5.BillItem;
import com.training.util.JPAUtil;



public class Main5 {

	
	static void insert(){
		
		Bill bill=new Bill("John David", LocalDate.now());
		
		BillItem item1=new BillItem(1, "Samsung Phone", 2, 24000.00);
		BillItem item2=new BillItem(2, "DELL Laptop", 1, 48000.00);
		BillItem item3=new BillItem(3, "iPhone", 2, 55000.00);
		
		bill.addBillItem(item1);
		bill.addBillItem(item2);
		bill.addBillItem(item3);
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		em.getTransaction().begin();
		em.persist(bill);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
		
		
		
	}
	
	static void read() {

		EntityManager em = JPAUtil.getEntityManager("PU");

		Bill bill;

		bill = em.find(Bill.class, 1);

		System.out.println(bill);
		JPAUtil.closeEntityManager();

	}

	static void readAll() {

		EntityManager em = JPAUtil.getEntityManager("PU");

		String str = "from Bill";
		Query query = em.createQuery(str);
		List<Bill> allbillss = query.getResultList();

		System.out.println(allbillss);

		JPAUtil.closeEntityManager();
	}

	static void update() {

		EntityManager em = JPAUtil.getEntityManager("PU");

		Bill bill;
		bill = em.find(Bill.class, 1);

		bill.addBillItem(new BillItem(4, "Buds", 1, 3000.0));
		bill.addBillItem(new BillItem(5, "Charger", 1, 5000.0));
		bill.setCustomerName(bill.getCustomerName().toUpperCase());
		bill.setBillingDate(LocalDate.of(2024, 10, 15));

		em.getTransaction().begin();
		em.merge(bill);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void delete() {
		Bill bill;
		EntityManager em = JPAUtil.getEntityManager("PU");

		bill = em.find(Bill.class, 1);

		em.getTransaction().begin();
		em.remove(bill);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();

	}

	public static void main(String[] args) {
		insert();

	}

}
