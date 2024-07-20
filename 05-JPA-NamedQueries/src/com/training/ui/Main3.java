package com.training.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.training.bean.Doctor;
import com.training.util.JPAUtil;


public class Main3 {
	
	static void test1() {
		EntityManager em=JPAUtil.getEntityManager("PU");

		Query query=em.createNamedQuery("readAll", Doctor.class);
		List doctors=query.getResultList();
		System.out.println(doctors);
		JPAUtil.closeEntityManager();
	}
	
	
	static void test2() {
		EntityManager em=JPAUtil.getEntityManager("PU");
		TypedQuery<Doctor> query=em.createNamedQuery("findById", Doctor.class);
		query.setParameter("searchId", 3);
		Doctor doctor=query.getSingleResult();
		System.out.println(doctor);
		JPAUtil.closeEntityManager();
	}

	public static void main(String[] args) {
		test2();

	}

}
 