package org.jsp.hibernateproject;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByPhoneAndPassword 
{
public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone number of employee");
		long pn = sc.nextLong();
		
		System.out.println("Enter Password");
		String pw = sc.next();
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<Employee> q=ses.createQuery("select e from Employee e where e.phone=?1 and e.password=?2");
    	q.setParameter(1, pn);
    	q.setParameter(2, pw);
    	try {
			Employee e = q.getSingleResult();
			System.out.println(e);
		} catch (Exception e) {
			System.err.println("Invalid Creadential");
		}
	}

}
