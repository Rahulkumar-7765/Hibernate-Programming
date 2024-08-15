package org.jsp.hibernateproject;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class DeletebyDelete 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee to Delete");
		int eid=sc.nextInt();
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
//		System.out.println(sef);
		Session ses=sef.openSession();
		Transaction tran=ses.getTransaction();
		tran.begin();
		Employee e=ses.get(Employee.class, eid);
		if(e!=null) {
			ses.delete(e);
			tran.commit();
		}
		else {
			System.err.println("Employee cannot be deteted since you have entered invalid id");
		}
		
	}

}
