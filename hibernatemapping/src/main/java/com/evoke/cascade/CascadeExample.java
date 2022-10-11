package com.evoke.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.evoke.onetomany.Account;
import com.evoke.onetomany.Bank;

public class CascadeExample {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s1 = factory.openSession();

		Bank bank = new Bank();
		bank.setBankId(20);
		bank.setBankName("Punjab National Bank");

		Account account = new Account(101, "Raman", 16789045, bank);
		Account account1 = new Account(102, "RojaPavan", 12569045, bank);

		List<Account> list = new ArrayList<Account>();
		list.add(account);
		list.add(account1);

		bank.setAccount(list);

		Transaction txt = s1.beginTransaction();

		s1.save(bank);
		
//     	s1.save(account);
//	    s1.save(account1);
		
		
		txt.commit();
        s1.close();
        
        
		factory.close();
	}

}
