package com.evoke.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.evoke.onetomany.Account;
import com.evoke.onetomany.Bank;


public class FirstLevel {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session= factory.openSession();
		
		Account account = session.get(Account.class, 102);
		System.out.println(account);
		
		
		
		
		session.close();
		factory.close();
	}

}
