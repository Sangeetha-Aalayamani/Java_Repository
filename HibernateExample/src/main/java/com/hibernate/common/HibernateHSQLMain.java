package com.hibernate.common;

import java.util.List;

import org.hibernate.Session;

import com.hibernate.persistence.HibernateUtil;

public class HibernateHSQLMain {
	public static void main(String[] args) {
		System.out.println("Hibernate -- connecting to HSQLDB");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockId(3);
		
		stock.setStockCode("A02");
		stock.setStockName("BABY CARE");

		session.save(stock);

		List query = session.createQuery(" from Stock ").list();
		System.out.println(query.size());

		session.getTransaction().commit();
	}
}
