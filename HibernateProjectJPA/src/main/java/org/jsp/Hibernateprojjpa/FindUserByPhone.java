package org.jsp.Hibernateprojjpa;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByPhone 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone of user");
		Long pn = sc.nextLong();
		
		
		
		
		Configuration configuration = new Configuration();
    	configuration.configure();
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<User> q=ses.createQuery("select u from User u where u.phone=?1");
    	q.setParameter(1, pn);
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
