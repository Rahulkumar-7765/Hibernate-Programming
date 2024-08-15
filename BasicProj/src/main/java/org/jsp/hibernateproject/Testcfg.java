package org.jsp.hibernateproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Testcfg 
{
	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
//		System.out.println(sef);
		Session ses=sef.openSession();
		Transaction tran=ses.getTransaction();
		tran.begin();
		Employee e=new Employee();
		e.setName("raj");
		e.setEmail("raj@gmail.com");
		e.setPassword("user@12");
		e.setPhone(7778892627L);
		e.setSalary(30000.0);
		ses.save(e);
		tran.commit();	
		
		
	}

}
