package org.jsp.hibernateproject;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class FetchByget 
{
	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
//		System.out.println(sef);
		try {
			Session ses=sef.openSession();
			Employee e=ses.load(Employee.class, 3);
			System.out.println(e);
		} catch (ObjectNotFoundException e) {
			System.out.println("No Employee found since you have enter invalid id");
			
		}
	
			
		}
	}


