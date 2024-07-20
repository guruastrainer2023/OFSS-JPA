package com.training.ui;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.training.bean.pack2.Category;
import com.training.bean.pack3.State;
import com.training.bean.pack4.CountryHolidays;
import com.training.util.JPAUtil;



public class Main4 {
	
	
	static void insert(){
		CountryHolidays countryHolidays=new CountryHolidays();
		countryHolidays.setCountryName("India");
		
		countryHolidays.addHoliday("Republic Day", LocalDate.of(2024, 1, 26));
		countryHolidays.addHoliday("Independence Day", LocalDate.of(2024, 8, 15));
		
		EntityManager em=JPAUtil.getEntityManager("PU");
		
		em.getTransaction().begin();
		em.persist(countryHolidays);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
		
		
	}
	
	static void read() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		CountryHolidays countryHolidays;

		countryHolidays = em.find(CountryHolidays.class, 1);

		System.out.println(countryHolidays);

		JPAUtil.closeEntityManager();
	}

	static void readAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		String str = "from CountryHolidays";
		Query query = em.createQuery(str);
		List<CountryHolidays> allholidays = query.getResultList();
		System.out.println(allholidays);
		JPAUtil.closeEntityManager();
	}

	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();
		CountryHolidays countryHolidays = em.find(CountryHolidays.class, 1);
		countryHolidays.addHoliday("diwali", LocalDate.of(2024, 9, 26));
		countryHolidays.addHoliday("Holi", LocalDate.of(2024, 1, 28));

		countryHolidays.setCountryName(countryHolidays.getCountryName().toUpperCase());

		em.merge(countryHolidays);
		em.getTransaction().commit();
		System.out.println(countryHolidays);
		JPAUtil.closeEntityManager();
	}

	static void delete() {

		EntityManager em = JPAUtil.getEntityManager("PU");
		CountryHolidays countryHolidays = em.find(CountryHolidays.class, 3);

		em.getTransaction().begin();
		em.remove(countryHolidays);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();

	}

	public static void main(String[] args) {
		insert();
	}

}


