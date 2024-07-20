package com.training.ui;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.training.bean.pack5.Bill;
import com.training.bean.pack5.BillItem;
import com.training.bean.pack7.Customer;
import com.training.bean.pack7.CustomerStatus;
import com.training.util.JPAUtil;



public class Main7 {

	static void insert() {
		Customer customer1 = new Customer("Apollo Medicals", 30000.00);
		Customer customer2 = new Customer("MedPlus", 40000.00);

		Map<String, Customer> map = new HashMap<>();
		map.put("GOOD", customer1);
		map.put("AVERAGE", customer2);

		CustomerStatus customerStatus = new CustomerStatus();
		customerStatus.setRegionName("Chennai");
		customerStatus.setStatusMap(map);

		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		em.persist(customerStatus);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();

	}

	static void read() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		CustomerStatus customerStatus;

		customerStatus = em.find(CustomerStatus.class, 1);

		System.out.println(customerStatus);

		JPAUtil.closeEntityManager();

	}

	static void readAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		String str = "from CustomerStatus";
		Query query = em.createQuery(str);
		List allCst = query.getResultList();
		System.out.println(allCst);
		JPAUtil.closeEntityManager();
	}

	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();
		CustomerStatus customerStatus = em.find(CustomerStatus.class, 1);
		customerStatus.setRegionName(customerStatus.getRegionName().toUpperCase());
		em.merge(customerStatus);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();
	}

	static void delete() {

		EntityManager em = JPAUtil.getEntityManager("PU");
		CustomerStatus customerStatus = em.find(CustomerStatus.class, 2);

		em.getTransaction().begin();
		em.remove(customerStatus);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();

	}

	public static void main(String[] args) {
		insert();

	}

}
