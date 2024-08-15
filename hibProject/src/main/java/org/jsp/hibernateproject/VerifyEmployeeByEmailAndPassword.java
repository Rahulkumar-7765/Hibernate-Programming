package org.jsp.hibernateproject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByEmailAndPassword
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email id of employee");
		String em = sc.next();
		
		System.out.println("Enter Password");
		String pw = sc.next();
		
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<Employee> q=ses.createQuery("select e from Employee e where e.email=?1 and e.password=?2");
    	q.setParameter(1, em);
    	q.setParameter(2, pw);
    	
    	try {
			Employee result = q.getSingleResult();
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("Invalid Creadential");
		}
	}

}
