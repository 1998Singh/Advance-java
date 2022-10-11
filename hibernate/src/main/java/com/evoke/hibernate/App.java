package com.evoke.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernet.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        
        // creating Student object
        Student std= new Student();
        std.setId(5);
        std.setName("Piyush Tomar");
        std.setBranch("Cse");
        std.setCity("Gwalior");
        
        System.out.println(std);
        
        //
        
   Session session= factory.openSession();
   Transaction txt= session.beginTransaction();
   session.save(std);
   txt.commit();
   session.close();
        
      //  System.out.println(factory);
     //   System.out.println(factory.isClosed());
       
    }
}
