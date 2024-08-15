package org.jsp.Hibernateprojjpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Saveuser 
{
	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
		Session ses=sef.openSession();
		Transaction tran=ses.beginTransaction();
		User u=new User();
		u.setName("Chhotu");
		u.setPhone(9897503810l);
		u.setEmail("chhotu@gmail.com");
		u.setPassword("chhotu@1234");
		ses.save(u);
		tran.commit();
		
		
	}

}
