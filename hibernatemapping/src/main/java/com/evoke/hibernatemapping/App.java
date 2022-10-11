package com.evoke.hibernatemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating question class object.
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What Is Java?");

		// creating Answer Class Object
		Answer ans = new Answer();
		ans.setAnswerId(343);
		ans.setAnswer("Java Is Programming Language.");
		ans.setQuestion(q1);
		q1.setAnswer(ans);

		// creating question class object.
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What Is Collection FrameWork?");

		// creating Answer Class Object
		Answer ans1 = new Answer();
		ans1.setAnswerId(344);
		ans1.setAnswer("API to work with Object in java .");
		ans.setQuestion(q2);
		q2.setAnswer(ans1);

		// Session
		Session s1 = factory.openSession();
		Transaction txt = s1.beginTransaction();
		
		s1.save(q1);
		s1.save(ans);
		s1.save(q2);
		s1.save(ans1);
		

		txt.commit();
		s1.close();
		factory.close();
	}
}
