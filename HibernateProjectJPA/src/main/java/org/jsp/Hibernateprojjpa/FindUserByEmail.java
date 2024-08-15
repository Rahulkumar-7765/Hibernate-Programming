package org.jsp.Hibernateprojjpa;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByEmail 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email of user");
		String em = sc.next();
		
		
		
		
		Configuration configuration = new Configuration();
    	configuration.configure();
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<User> q=ses.createQuery("select u from User u where u.email=?1");
    	q.setParameter(1, em);
    	 User us=q.getSingleResult();
//    	if(us.size()<0) {
//    		for(User u:us) {
//    			System.out.println(u);
//    		}
//    	}
    	
    	
    	try {
			User result =  q.getSingleResult();
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("Invalid Creadential");
		}
		
	}

}
