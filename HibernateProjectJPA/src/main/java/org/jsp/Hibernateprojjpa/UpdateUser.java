package org.jsp.Hibernateprojjpa;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UpdateUser 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id which you want to update");
		int id = sc.nextInt();
	
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		
		User u=new User();
		u.setId(id);
		u.setName("Golu");
		u.setPhone(9987654935L);
		u.setEmail("golu@123gmail.com"); 
		u.setPassword("golu@1234");
		session.update(u);
		tran.commit();
		sc.close();
		
	}

}
