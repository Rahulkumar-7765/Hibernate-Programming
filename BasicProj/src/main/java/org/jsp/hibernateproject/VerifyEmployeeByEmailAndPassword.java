package org.jsp.hibernateproject;

import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByEmailAndPassword
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email id of Employee");
		String em=sc.next();
		
		System.out.println("Enter password of Employee");
		String pw=sc.next();
		
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
		Session ses=sef.openSession();
		Query<Employee> q=ses.createQuery("Select e from Employee e where e.email=?1 and e.password=?2");
		q.setParameter(1, em);
		q.setParameter(2, pw);
		
		try {
			Employee e=q.getSingleResult();
			System.out.println(e);
			System.out.println("Employee is Verified");
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("Invalid Credentials");
		}
		
		
	}

}
