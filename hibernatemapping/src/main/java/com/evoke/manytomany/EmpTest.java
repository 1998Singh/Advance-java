package com.evoke.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpTest {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		// Emp object
		Emp e1= new Emp();
		Emp e2= new Emp();
		
		e1.seteId(101);
		e1.setName("Abhishek Saini");
		
		e2.seteId(102);
		e2.setName("Raman");
		
		// project object
		Project p1= new Project();
		Project p2= new Project();
		
		p1.setpId(12);
		p1.setProjectName("Student Management Application");
		
		p2.setpId(13);
		p2.setProjectName("ChatBoat");
		 
		// lists
		List<Emp> list = new ArrayList<Emp>();
		List<Project> list1 = new ArrayList<Project>();
		 
		list.add(e1);
		list.add(e2);
		
		list1.add(p1);
		list1.add(p2);
		
		//
		e1.setProjects(list1);
		p1.setEmps(list);
		
		
		Session s = factory.openSession();
		Transaction txt = s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		txt.commit();
		s.close();
		factory.close();

	}

}
