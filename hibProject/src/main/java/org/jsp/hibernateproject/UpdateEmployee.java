package org.jsp.hibernateproject;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee 
{
public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id which you want to update");
		int id = sc.nextInt();
	
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		
		Employee e=new Employee();
		e.setId(id);
		e.setName("Allu");
		e.setPhone(9987654335L);
		e.setEmail("allu@123gmail.com");
		e.setDesignation("SupportEnginear");
		e.setSalary(800000.00);
		e.setPassword("al");
		session.update(e);
		tran.commit();
	}

}
