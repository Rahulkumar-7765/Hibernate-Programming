package org.jsp.hibernateproject;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FetchByUpdate 
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
		e.setId(7);
		e.setName("sujeet");
		e.setEmail("sujeet@gmail.com");
		e.setPassword("sujeet@123");
		e.setPhone(8769876756L);
		e.setSalary(27000.0);
//		ses.update(e);
		ses.saveOrUpdate(e);
		tran.commit();
		
	}

}
