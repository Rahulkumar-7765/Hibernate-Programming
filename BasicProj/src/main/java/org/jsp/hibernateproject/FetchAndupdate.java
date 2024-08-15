package org.jsp.hibernateproject;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FetchAndupdate 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id to update");
		int id=sc.nextInt();
		
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
//		System.out.println(sef);
		Session ses=sef.openSession();
		Transaction tran=ses.getTransaction();
		tran.begin();
		Employee e=ses.get(Employee.class, id);
		if(e!=null) {
			e.setEmail("badal@gmail.com");
			e.setPassword("badal@123");
			tran.commit();
		}
		else {
			System.out.println("No id found since you are entered wrong id");
		}
	}

}
