package com.evoke.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestBank {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating the object for bank class

		Bank bank = new Bank();
		bank.setBankId(101);
		bank.setBankName("State bank Of India");

		// creating the object for Account class.
		Account account = new Account();
		account.setAccountId(1);
		account.setAccountNo(123456);
		account.setAccountHoldername("Abhit");
		account.setBank(bank);

		Account account1 = new Account();
		account1.setAccountId(2);
		account1.setAccountNo(113457);
		account1.setAccountHoldername("Rishabh");
		account1.setBank(bank);

		Account account2 = new Account();
		account2.setAccountId(3);
		account2.setAccountNo(113007);
		account2.setAccountHoldername("Shubham");
		account2.setBank(bank);

		// creating List of account
		List<Account> list = new ArrayList<Account>();
		list.add(account);
		list.add(account1);
		list.add(account2);

		 bank.setAccount(list);

		// Session
		Session s1 = factory.openSession();
		Transaction txt = s1.beginTransaction();

		s1.save(bank);
		s1.save(account);
		s1.save(account1);
		s1.save(account2);

		Bank bank1 = (Bank) s1.get(Bank.class, 101);
		System.out.println(bank1.getBankId());
		System.out.println(bank1.getBankName());
		System.out.println(bank1.getAccount().size());

		txt.commit();
		s1.close();
		factory.close();

	}

}
