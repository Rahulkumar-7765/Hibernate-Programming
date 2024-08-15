package org.jsp.Hibernateprojjpa;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class VerifyUserEmailAndPassword 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email id of user");
		String em = sc.next();
		
		System.out.println("Enter Password");
		String pw = sc.next();
		
		
		Configuration configuration = new Configuration();
    	configuration.configure();
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<User> q=ses.createQuery("select u from User u where u.email=?1 and u.password=?2");
    	q.setParameter(1, em);
    	q.setParameter(2, pw);
    	
    	try {
			List<User> result = q.getResultList();
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("Invalid Creadential");
		}
		
	}

}
