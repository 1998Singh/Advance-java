package com.evoke.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.evoke.manytomany.Emp;

public class HqlExample {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session s1 = factory.openSession();

		// HQL Quary
		String quary = "from Emp where eId=101";
		Query q = s1.createQuery(quary);
		List<Emp> list = q.list();

		for (Emp emp : list) {
			System.out.println(emp.getName());
		}

		s1.close();
		factory.close();
	}

}
