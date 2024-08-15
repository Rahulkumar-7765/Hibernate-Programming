package org.jsp.hibernateproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee 
{
public static void main(String[] args) {
		
		Employee e=new Employee();
		e.setName("Suraj");
		e.setPhone(987065431L);
		e.setEmail("suraj@123gmail.com");
		e.setDesignation("Software Enginear");
		e.setSalary(30000.00);
		e.setPassword("123456");
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		
		Object save = session.save(e);
		System.out.println("Record saved in db "+save);
		tran.commit();
	}

}
