package org.jsp.Hibernateprojjpa;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class VerifyUserByPhoneAndPassword 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone number of user");
		long pn = sc.nextLong();
		
		System.out.println("Enter Password");
		String pw = sc.next();
		
		Configuration configuration = new Configuration();
    	configuration.configure();
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<User> q=ses.createQuery("select u from User u where u.phone=?1 and u.password=?2");
    	q.setParameter(1, pn);
    	q.setParameter(2, pw);
    	try {
			List<User> u = q.getResultList();
			System.out.println(u);
		} catch (Exception e) {
			System.err.println("Invalid Creadential");
		}
		
	}

}
