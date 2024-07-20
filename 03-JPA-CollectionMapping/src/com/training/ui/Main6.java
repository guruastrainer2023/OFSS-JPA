package com.training.ui;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.training.bean.pack5.Bill;
import com.training.bean.pack5.BillItem;
import com.training.bean.pack6.FeeDetail;
import com.training.bean.pack6.FeePayment;
import com.training.util.JPAUtil;



public class Main6 {

	static void insert() {
		FeeDetail feeDetail = new FeeDetail();
		feeDetail.setFeeAmount(10000);

		FeePayment payment1 = new FeePayment("Jan", 2000.00);
		FeePayment payment2 = new FeePayment("Feb", 3000.00);
		FeePayment payment3 = new FeePayment("Mar", 1500.00);

		Set<FeePayment> payments = new HashSet<>();
		payments.add(payment1);
		payments.add(payment2);
		payments.add(payment3);

		feeDetail.setPayments(payments);

		EntityManager em = JPAUtil.getEntityManager("PU");

		em.getTransaction().begin();
		em.persist(feeDetail);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();

	}

	static void read() {
		EntityManager em = JPAUtil.getEntityManager("PU");

		FeeDetail feeDetail;

		feeDetail = em.find(FeeDetail.class, 1);

		System.out.println(feeDetail);

		JPAUtil.closeEntityManager();

	}

	static void readAll() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		String str = "from FeeDetail";
		Query query = em.createQuery(str);
		List allFees = query.getResultList();
		System.out.println(allFees);
		JPAUtil.closeEntityManager();
	}

	static void update() {
		EntityManager em = JPAUtil.getEntityManager("PU");
		em.getTransaction().begin();
		FeeDetail feeDetail = em.find(FeeDetail.class, 1);
		feeDetail.setFeeAmount(25000);
		em.merge(feeDetail);
		em.getTransaction().commit();
		System.out.println(feeDetail);
		JPAUtil.closeEntityManager();
	}

	static void delete() {

		EntityManager em = JPAUtil.getEntityManager("PU");
		FeeDetail feeDetail = em.find(FeeDetail.class, 3);

		em.getTransaction().begin();
		em.remove(feeDetail);
		em.getTransaction().commit();

		JPAUtil.closeEntityManager();

	}

	public static void main(String[] args) {
		insert();

	}

}
