package org.jsp.Hibernateprojjpa;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyUserByIdAndPassword 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User  id of User");
		int id = sc.nextInt();
		
		System.out.println("Enter Password");
		String pw = sc.next();
		
		
		Configuration conf = new Configuration();
    	conf.configure();
    	SessionFactory fac = conf.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<User> q = ses.createQuery("select u from User u where u.id=?1 and u.password=?2");
    	q.setParameter(1, id);
    	q.setParameter(2, pw);
    	
    	try {
			User result = q.getSingleResult();
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("Invalid Creadential");
		}
    	sc.close();
		
	}

}
